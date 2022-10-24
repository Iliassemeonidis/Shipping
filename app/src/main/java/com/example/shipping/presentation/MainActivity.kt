package com.example.shipping.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shipping.R
import com.example.shipping.domain.ShopItem
import com.example.shipping.presentation.ShopListAdapter.Companion.MAX_POOL_SIZE
import com.example.shipping.presentation.ShopListAdapter.Companion.TYPE_ITEM2_DESABLED
import com.example.shipping.presentation.ShopListAdapter.Companion.TYPE_ITEM_ENABLE

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var shopListAdapter: ShopListAdapter


    private var itemTouchHelper = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val view = shopListAdapter.currentList[viewHolder.adapterPosition]
            mainViewModel.deleteShopItem(view)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpAdapter()

        initViewModel()
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.liveData.observe(this) {
            shopListAdapter.submitList(it)
        }
    }

    private fun setUpAdapter() {
        shopListAdapter = ShopListAdapter()
        val resAdapter: RecyclerView = findViewById(R.id.rv_shop_list)

        with(resAdapter) {
            adapter = shopListAdapter
            recycledViewPool.setMaxRecycledViews(TYPE_ITEM_ENABLE, MAX_POOL_SIZE)
            recycledViewPool.setMaxRecycledViews(TYPE_ITEM2_DESABLED, MAX_POOL_SIZE)
            shopListAdapter.onShopItemLongClickListener = {
                mainViewModel.changeEnableState(it)
            }

            shopListAdapter.onShopItemClickListener = {
                Log.d("POSITION", "${it.id}")
            }

            val itemHelper = ItemTouchHelper(itemTouchHelper)
            itemHelper.attachToRecyclerView(resAdapter)

        }
    }

}