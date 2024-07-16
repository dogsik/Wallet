package com.example.wallet.presentation.asset_list.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.databinding.ItemAssetBinding
import com.example.wallet.domain.entity.Asset

class AssetListAdapter : RecyclerView.Adapter<AssetViewHolder>() {
    private var items = emptyList<Asset>()
    var onClick: (Asset) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        return AssetViewHolder(
            ItemAssetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun submit(newItems: List<Asset>) {
        val diffUtilCallback = AssetDiffUtilCallback(items, newItems)
        items = newItems
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }
}