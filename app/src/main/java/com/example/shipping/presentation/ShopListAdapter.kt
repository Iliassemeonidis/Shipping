package com.example.shipping.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.shipping.R
import com.example.shipping.domain.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiff()) {

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layoutResId = when (viewType) {
            TYPE_ITEM_ENABLE -> {
                R.layout.item_shop_enabled
            }
            else -> R.layout.item_shop_disabled
        }

        val view = LayoutInflater.from(parent.context).inflate(
            layoutResId,
            parent,
            false
        )
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        with(viewHolder) {
            view.setOnLongClickListener {
                onShopItemLongClickListener?.invoke(shopItem)
                true
            }
            view.setOnClickListener {
                onShopItemClickListener?.invoke(shopItem)
            }
            tvName.text = shopItem.description
            tvCount.text = shopItem.count.toString()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enable) {
            TYPE_ITEM_ENABLE
        } else TYPE_ITEM2_DESABLED
    }

    companion object {
        const val TYPE_ITEM_ENABLE = 1
        const val TYPE_ITEM2_DESABLED = 2
        const val MAX_POOL_SIZE = 30
    }
}