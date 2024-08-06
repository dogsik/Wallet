package com.example.wallet.presentation.asset_list.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.databinding.ItemAssetBinding
import com.example.wallet.domain.entity.Asset
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AssetListAdapter : RecyclerView.Adapter<AssetViewHolder>() {
    private var items = emptyList<Asset>()
    var onClick: (Asset) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        return AssetViewHolder(
            ItemAssetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun submit(newItems: List<Asset>) {
        CoroutineScope(Dispatchers.IO).launch {
            val diffResult = withContext(Dispatchers.Default) {
                val diffUtilCallback = AssetDiffUtilCallback(items, newItems)
                DiffUtil.calculateDiff(diffUtilCallback)
            }
            items = newItems
            diffResult.dispatchUpdatesTo(this@AssetListAdapter)
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }
}
