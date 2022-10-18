package com.example.shipping.domain

class DeleteShopItemUseCase (private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.getShopItem(shopItem)
    }
}