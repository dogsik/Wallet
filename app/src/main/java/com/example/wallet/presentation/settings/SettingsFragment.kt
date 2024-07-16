package com.example.wallet.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.wallet.databinding.FragmentSettingsBinding
import com.example.wallet.presentation.util.string_selector_bottom_sheet.ChooseDefaultCurrencyFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val settingViewModel: SettingViewModel by viewModels()
    private lateinit var dialog: ChooseDefaultCurrencyFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.openBottomSheet.setOnClickListener {
            dialog = ChooseDefaultCurrencyFragment()
            dialog.show(parentFragmentManager, "ChooseDefaultCurrencyFragment")
        }
        settingViewModel.settings.observe(viewLifecycleOwner) { currency ->
            binding.openBottomSheet.text = currency
        }
        setFragmentResultListener("currencyKey") { requestKey, bundle ->
            val result = bundle.getString("currencyName")
            if (result != null) {
                settingViewModel.setCurrency(result)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
