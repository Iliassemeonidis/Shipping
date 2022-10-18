package com.example.shipping.data

import com.example.shipping.domain.ShopItem
import com.example.shipping.domain.ShopListRepository

class ShopListRepositoryImpl : ShopListRepository {
   private val shopList  = mutableListOf<ShopItem>()

    override fun addShopItem(shopItem: ShopItem) {
        shopList.add(shopItem)
    }

    override fun delItemFromShopList(shopItemId: Int) {

    }

    override fun editShopList(shopItem: ShopItem) {
        TODO("Not yet implemented")
    }

    override fun getShopItem(shopItem: ShopItem): ShopItem {
        TODO("Not yet implemented")
    }

    override fun getShopList(): List<ShopItem> {
        TODO("Not yet implemented")
    }
}