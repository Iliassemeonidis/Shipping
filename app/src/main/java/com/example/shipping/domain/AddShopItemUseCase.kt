package com.example.shipping.domain

class AddShopItemUseCase(private val shopList: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem) {
        shopList.addShopItem(shopItem)
    }
}