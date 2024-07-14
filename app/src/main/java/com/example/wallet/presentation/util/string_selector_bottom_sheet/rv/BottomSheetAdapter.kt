package com.example.wallet.presentation.util.string_selector_bottom_sheet.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.databinding.ItemBottomSheetBinding
import com.example.wallet.domain.entity.Currency

class BottomSheetAdapter : RecyclerView.Adapter<BottomSheetViewHolder>() {
    private var items = emptyList<Currency>()
    var onClick: (Currency) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder {
        return BottomSheetViewHolder(
            ItemBottomSheetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun submit(newItems: List<Currency>) {
        val diffUtilCallback = BottomSheetDiffUtilCallback(items, newItems)
        items = newItems
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }
}
