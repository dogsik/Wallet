package com.example.wallet.presentation.util.string_selector_bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import com.example.wallet.databinding.FragmentBottomSheetBinding
import com.example.wallet.presentation.util.string_selector_bottom_sheet.rv.BottomSheetAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseDefaultCurrencyFragment : BottomSheetDialogFragment() {
    companion object {
        private const val KEY_CURRENCY = "currencyKey"
        private const val KEY_CURRENCY_NAME = "currencyName"
    }
    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!
    private val currencyViewModel: CurrencyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BottomSheetAdapter()

        adapter.onClick = { currency ->
            setFragmentResult(KEY_CURRENCY, bundleOf(KEY_CURRENCY_NAME to currency.currencyName))
            dismiss()
        }

        binding.recyclerBottomSheet.adapter = adapter
        currencyViewModel.currencies.observe(viewLifecycleOwner) { currencies ->
            adapter.submit(currencies)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
