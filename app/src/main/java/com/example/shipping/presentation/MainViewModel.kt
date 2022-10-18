package com.example.shipping.presentation

import androidx.lifecycle.ViewModel
import com.example.shipping.data.ShopListRepositoryImpl
import com.example.shipping.domain.DeleteShopItemUseCase
import com.example.shipping.domain.EditShopItemUseCase
import com.example.shipping.domain.GetShopListUseCase
import com.example.shipping.domain.ShopItem

class MainViewModel : ViewModel() {

    private val shopListRepository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(shopListRepository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(shopListRepository)
    private val editShopItemUseCase = EditShopItemUseCase(shopListRepository)

     val liveData = getShopListUseCase.getShopList()



    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enable = !shopItem.enable)
        editShopItemUseCase.editShopList(newItem)
    }

}