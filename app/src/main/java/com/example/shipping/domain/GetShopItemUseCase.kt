package com.example.shipping.domain

class GetShopItemUseCase(private val shopList: ShopListRepository) {

    fun getShopItem(shopItem: ShopItem): ShopItem {
        return shopList.getShopItem(shopItem)
    }
}