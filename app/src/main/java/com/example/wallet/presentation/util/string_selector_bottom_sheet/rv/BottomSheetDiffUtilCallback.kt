package com.example.wallet.presentation.util.string_selector_bottom_sheet.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.wallet.domain.entity.Currency

class BottomSheetDiffUtilCallback(
    private val oldList: List<Currency>,
    private val newList: List<Currency>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].ordinal == newList[newItemPosition].ordinal

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}
