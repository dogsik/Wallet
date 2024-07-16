package com.example.wallet.presentation.asset_list.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.wallet.domain.entity.Asset

class AssetDiffUtilCallback(
    private val oldList: List<Asset>,
    private val newList: List<Asset>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}