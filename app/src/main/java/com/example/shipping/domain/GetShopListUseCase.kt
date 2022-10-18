package com.example.shipping.domain

class GetShopListUseCase(private val shopList: ShopListRepository) {

    fun getShopList(): List<ShopItem> {
     return   shopList.getShopList()
    }
}