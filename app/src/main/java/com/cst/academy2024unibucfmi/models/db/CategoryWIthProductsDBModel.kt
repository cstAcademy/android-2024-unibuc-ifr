package com.cst.academy2024unibucfmi.models.db

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryWithProductsDBModel (
    @Embedded val category: ProductCategoryDBModel,
    @Relation(
        parentColumn = ProductCategoryDBModel.ARG_NAME,
        entityColumn = ProductDBModel.ARG_CATEGORY_NAME
    )
    val products: List<ProductDBModel>
)