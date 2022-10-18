package com.example.shipping.data

import com.example.shipping.domain.ShopItem
import com.example.shipping.domain.ShopItem.Companion.UNDEFINDEN_ID
import com.example.shipping.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == UNDEFINDEN_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopList(shopItem: ShopItem) {
        val oldShopItem = shopList[shopItem.id]
        shopList.remove(oldShopItem)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItem: Int): ShopItem {
        return shopList.find {
            it.id == shopItem
        } ?: throw RuntimeException("Element with id $shopItem is not find")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

}