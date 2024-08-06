package com.example.wallet.presentation.asset_list.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.databinding.ItemAssetBinding
import com.example.wallet.domain.entity.Asset

class AssetViewHolder(
    private val binding: ItemAssetBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: Asset, onClick: (Asset) -> Unit) {
        with(binding) {
            assetName.text = model.name
            assetPrice.text = String.format("%.3f", model.purchasePrice)
            root.setOnClickListener {
                onClick(model)
            }
        }
    }
}
