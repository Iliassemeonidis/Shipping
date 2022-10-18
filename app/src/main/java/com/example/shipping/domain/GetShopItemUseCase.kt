package com.example.shipping.domain

class GetShopItemUseCase(private val shopList: ShopListRepository) {

    fun getShopItem(shopItem: Int): ShopItem {
        return shopList.getShopItem(shopItem)
    }
}