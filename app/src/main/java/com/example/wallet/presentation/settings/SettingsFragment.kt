package com.example.wallet.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wallet.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    companion object {
        private const val KEY_CURRENCY = "currencyKey"
        private const val KEY_CURRENCY_NAME = "currencyName"
    }
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val settingViewModel: SettingViewModel by viewModels()

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
            val action = SettingsFragmentDirections
                .actionSettingsFragmentToChooseDefaultCurrencyFragment()
            findNavController().navigate(action)
        }
        settingViewModel.settings.observe(viewLifecycleOwner) { currency ->
            binding.openBottomSheet.text = currency
        }
        setFragmentResultListener(KEY_CURRENCY) { _, bundle ->
            val result = bundle.getString(KEY_CURRENCY_NAME)
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
