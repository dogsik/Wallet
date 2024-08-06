package com.example.wallet.presentation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallet.domain.repository.SettingStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
        viewModelScope.launch {
            _settings.value = settingStore.getCurrency()
        }
    }

    fun setCurrency(currency: String) {
        viewModelScope.launch {
            settingStore.saveCurrency(currency)
            _settings.value = settingStore.getCurrency()
        }
    }
}
