package com.example.shipping.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopList(shopItem: ShopItem)
    fun getShopItem(shopItem: ShopItem) : ShopItem
    fun getShopList(): List<ShopItem>

}