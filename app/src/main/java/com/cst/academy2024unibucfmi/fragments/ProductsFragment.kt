package com.cst.academy2024unibucfmi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.cst.academy2024unibucfmi.R
import com.cst.academy2024unibucfmi.adapters.CartItemListAdapter
import com.cst.academy2024unibucfmi.data.repositories.ProductRepository
import com.cst.academy2024unibucfmi.models.CartItemModel
import com.cst.academy2024unibucfmi.models.CategoryModel
import com.cst.academy2024unibucfmi.models.ProductModel
import com.cst.academy2024unibucfmi.models.api.ProductAPIResponseModel
import com.cst.academy2024unibucfmi.models.db.ProductDBModel
import com.cst.academy2024unibucfmi.utils.VolleyRequestQueue
import com.cst.academy2024unibucfmi.utils.extensions.logErrorMessage
import com.cst.academy2024unibucfmi.utils.extensions.showToast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductsFragment : Fragment() {

    private val cartItemList = ArrayList<CartItemModel>()

    private val adapter by lazy {
        CartItemListAdapter(cartItemList)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_products, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        getProducts()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(context)

        view?.findViewById<RecyclerView>(R.id.rv_products)?.apply {
            this.layoutManager = layoutManager
            this.adapter = this@ProductsFragment.adapter
        }
    }

    private fun getProducts() {
        val url = "https://fakestoreapi.com/products"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                handleProductsResponse(response)
            },
            {
                "That didn't work!".logErrorMessage()
            })

        // Add the request to the RequestQueue.
        VolleyRequestQueue.addToRequestQueue(stringRequest)
    }

    private fun handleProductsResponse(response: String) {
        val type = object : TypeToken<List<ProductAPIResponseModel>>() {}.type
        val responseJsonArray = Gson().fromJson<List<ProductAPIResponseModel>>(response, type)

        responseJsonArray.getOrNull(0)?.let { responseProduct ->
            insertProductToDB(responseProduct)
        }

        responseJsonArray
            .groupBy { it.category }
            .forEach {
                val categoryModel = CategoryModel(
                    name = it.key,
                    description = it.key,
                )

                val products = it.value.map { productApi ->
                    ProductModel(
                        name = productApi.name,
                        description = productApi.description
                    )
                }

                cartItemList.add(categoryModel)
                cartItemList.addAll(products)
            }

        adapter.notifyItemRangeInserted(0, cartItemList.size)
    }

    // TODO add all products to local database
    private fun insertProductToDB(productModel: ProductAPIResponseModel) {
        ProductRepository.insert(productModel) {
            "Product successfully inserted".showToast(context)
        }
    }
}