package com.example.shipping.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopList(shopItem: ShopItem)
    fun getShopItem(shopItem: ShopItem) : ShopItem
    fun getShopList(): LiveData<List<ShopItem>>

}