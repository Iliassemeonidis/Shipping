package com.example.shipping.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopList: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
     return  shopList.getShopList()
    }
}