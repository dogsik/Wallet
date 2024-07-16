package com.example.wallet.presentation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.domain.repository.SettingStore
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val settingStore: SettingStore
) : ViewModel() {
    private val _settings: MutableLiveData<String> = MutableLiveData()
    val settings: LiveData<String> get() = _settings

    init {
        loadCurrency()
    }

    private fun loadCurrency() {
        _settings.value = settingStore.getCurrency()
    }

    fun setCurrency(currency: String) {
        settingStore.saveCurrency(currency)
        _settings.value = settingStore.getCurrency()
    }
}
