package com.cst.academy2024unibucfmi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cst.academy2024unibucfmi.R
import com.cst.academy2024unibucfmi.models.CartItemModel
import com.cst.academy2024unibucfmi.models.CartItemType
import com.cst.academy2024unibucfmi.models.CategoryModel
import com.cst.academy2024unibucfmi.models.ProductModel
import com.cst.academy2024unibucfmi.utils.extensions.logErrorMessage

class CartItemListAdapter(
    private val cartItemList: List<CartItemModel>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = cartItemList.size

    override fun getItemViewType(position: Int) = cartItemList[position].type.key

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType) {
            CartItemType.PRODUCT.key -> {
                "onCreateViewHolder --> PRODUCT".logErrorMessage("ProductListAdapter")

                val view = inflater.inflate(R.layout.item_product, parent, false)
                ProductViewHolder(view)
            }

            CartItemType.PRODUCT_CATEGORY.key -> {
                "onCreateViewHolder --> CATEGORY".logErrorMessage("ProductListAdapter")

                val view = inflater.inflate(R.layout.item_product_category, parent, false)
                ProductCategoryViewHolder(view)
            }

            else -> super.createViewHolder(parent, viewType)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        "onBindViewHolder; position=$position".logErrorMessage("ProductListAdapter")

        val model = cartItemList.getOrNull(position) ?: return

        when(holder) {
            is ProductViewHolder -> (model as? ProductModel)?.let { holder.bind(it) }

            is ProductCategoryViewHolder -> (model as? CategoryModel)?.let { holder.bind(it) }
        }
    }

    inner class ProductViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        val productNameTextView: TextView
        val productDescriptionTextView: TextView

        init {
            productNameTextView = view.findViewById(R.id.tv_product_name)
            productDescriptionTextView = view.findViewById(R.id.tv_product_description)
        }

        fun bind(model: ProductModel) {
            productNameTextView.text = model.name
            productDescriptionTextView.text = model.description
        }
    }

    inner class ProductCategoryViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        val categoryNameTextView: TextView
        val categoryDescriptionTextView: TextView

        init {
            categoryNameTextView = view.findViewById(R.id.tv_product_category_name)
            categoryDescriptionTextView = view.findViewById(R.id.tv_product_category_description)
        }

        fun bind(model: CategoryModel) {
            categoryNameTextView.text = model.name
            categoryDescriptionTextView.text = model.description
        }
    }
}