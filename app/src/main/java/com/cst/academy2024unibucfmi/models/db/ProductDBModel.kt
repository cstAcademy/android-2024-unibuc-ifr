package com.cst.academy2024unibucfmi.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("products")
data class ProductDBModel(
    @PrimaryKey
    @ColumnInfo(name = ARG_ID)
    val id: Int,
    @ColumnInfo(name = "title")
    val name: String,
    @ColumnInfo(name = ARG_CATEGORY_NAME)
    val categoryName: String,
    val description: String
) {
    companion object {
        const val ARG_ID = "id"
        const val ARG_CATEGORY_NAME = "categoryName"
    }
}