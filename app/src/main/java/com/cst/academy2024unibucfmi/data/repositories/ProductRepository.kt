package com.cst.academy2024unibucfmi.data.repositories

import com.cst.academy2024unibucfmi.data.tasks.product.GetCategoryWithProductsTask
import com.cst.academy2024unibucfmi.data.tasks.product.InsertProductTask
import com.cst.academy2024unibucfmi.models.api.ProductAPIResponseModel
import com.cst.academy2024unibucfmi.models.db.CategoryWithProductsDBModel
import com.cst.academy2024unibucfmi.models.db.ProductCategoryDBModel
import com.cst.academy2024unibucfmi.models.db.ProductDBModel

object ProductRepository {

    fun insert(model: ProductAPIResponseModel, onFinish: () -> Unit) {
        val product = ProductDBModel(
            id = model.id,
            name = model.name,
            categoryName = model.category,
            description = model.description
        )

        val category = ProductCategoryDBModel(model.category)

        InsertProductTask(
            product = product,
            category = category,
            onFinish = onFinish
        ).execute()
    }

    fun getCategoryWithProducts(onFinish: (List<CategoryWithProductsDBModel>) -> Unit) {
        GetCategoryWithProductsTask(onFinish).execute()
    }

}