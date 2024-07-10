package com.example.wallet.presentation.asset_list.vh

import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.data.defaults.Asset
import com.example.wallet.databinding.ItemAssetBinding

class AssetViewHolder(
    private val binding: ItemAssetBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: Asset, onClick: (Asset) -> Unit) {
        binding.assetName.text = model.name
        binding.assetPrice.text = model.value.toString()
        binding.root.setOnClickListener { onClick(model) }
    }
}
