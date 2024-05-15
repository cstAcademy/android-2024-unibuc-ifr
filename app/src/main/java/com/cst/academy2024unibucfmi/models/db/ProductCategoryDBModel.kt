package com.cst.academy2024unibucfmi.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("product_category")
data class ProductCategoryDBModel(
    @PrimaryKey
    @ColumnInfo(name = ARG_NAME)
    val name: String
) {
    companion object {
        const val ARG_NAME = "name"
    }
}