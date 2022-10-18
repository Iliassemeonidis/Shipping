package com.example.shipping.domain

data class ShopItem(
    val description: String,
    val count: Int,
    val enable: Boolean,
    var id: Int = UNDEFINDEN_ID
){
    companion object{
        const val UNDEFINDEN_ID = -1
    }
}
