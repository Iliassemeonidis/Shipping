package com.example.shipping.domain

data class ShopItem(
    val id: Int,
    val description: String,
    val count: Int,
    val enable: Boolean
)
