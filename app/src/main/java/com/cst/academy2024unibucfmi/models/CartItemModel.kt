package com.cst.academy2024unibucfmi.models

enum class CartItemType(val key: Int) {
    PRODUCT(0),
    PRODUCT_CATEGORY(1)
}

sealed class CartItemModel(
    val type: CartItemType
)

