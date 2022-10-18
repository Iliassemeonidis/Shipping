package com.example.shipping.domain

class EditShopItemUseCase(private val shopList: ShopListRepository) {

    fun editShopList(shopItem: ShopItem) {
        shopList.editShopList(shopItem)
    }
}