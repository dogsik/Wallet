package com.example.wallet.presentation.util.string_selector_bottom_sheet.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.databinding.ItemBottomSheetBinding
import com.example.wallet.domain.entity.Currency

class BottomSheetViewHolder(
    private val binding: ItemBottomSheetBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(currencyModel: Currency, onClick: (Currency) -> Unit) {
        with(binding) {
            stringValue.text = currencyModel.currencyName
            root.setOnClickListener {
                onClick(currencyModel)
            }
        }
    }
}
