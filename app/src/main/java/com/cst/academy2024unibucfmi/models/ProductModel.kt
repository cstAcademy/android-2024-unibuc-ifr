package com.cst.academy2024unibucfmi.models

data class ProductModel(
    val name: String,
    val description: String
) : CartItemModel(
    type = CartItemType.PRODUCT
)