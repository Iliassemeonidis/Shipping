package com.example.shipping.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shipping.domain.ShopItem
import com.example.shipping.domain.ShopItem.Companion.UNDEFINDEN_ID
import com.example.shipping.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    private val livaDT = MutableLiveData<List<ShopItem>>()

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Mame $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == UNDEFINDEN_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopList(shopItem: ShopItem) {
        val oldShopItem = shopList[shopItem.id]
        shopList.remove(oldShopItem)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItem: ShopItem): ShopItem {
        return shopList.find {
            it.id == shopItem.id
        } ?: throw RuntimeException("Element with id $shopItem is not find")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return livaDT
    }

    private fun updateList(){
        livaDT.value = shopList.toList()
    }

}