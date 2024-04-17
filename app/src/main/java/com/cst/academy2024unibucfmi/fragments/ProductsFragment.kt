package com.cst.academy2024unibucfmi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cst.academy2024unibucfmi.R
import com.cst.academy2024unibucfmi.adapters.ProductListAdapter
import com.cst.academy2024unibucfmi.models.CategoryModel
import com.cst.academy2024unibucfmi.models.ProductModel

class ProductsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_products, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(context)

        val productList = listOf(
            CategoryModel(
                name = "Category name 1",
                description = "Category description 1"
            ),
            ProductModel(
                name = "Product name 1",
                description = "Product description 1"
            ),
            ProductModel(
                name = "Product name 2",
                description = "Product description 1"
            ),
            ProductModel(
                name = "Product name 3",
                description = "Product description 1"
            ),
            ProductModel(
                name = "Product name 4",
                description = "Product description 1"
            ),
            ProductModel(
                name = "Product name 5",
                description = "Product description 1"
            ),
            ProductModel(
                name = "Product name 6",
                description = "Product description 1"
            ),
            ProductModel(
                name = "Product name 7",
                description = "Product description 1"
            ),
            ProductModel(
                name = "Product name 8",
                description = "Product description 1"
            ),
            ProductModel(
                name = "Product name 9",
                description = "Product description 1"
            ),
            CategoryModel(
                name = "Category name 2",
                description = "Category description 2"
            ),
            ProductModel(
                name = "Product name 10",
                description = "Product description 1"
            ),
        )

        val adapter = ProductListAdapter(productList)

        view?.findViewById<RecyclerView>(R.id.rv_products)?.apply {
            this.layoutManager = layoutManager
            this.adapter = adapter
        }
    }

}