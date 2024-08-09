package com.example.wallet.presentation.util.string_selector_bottom_sheet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallet.domain.entity.Currency
import com.example.wallet.domain.interactor.CurrencyInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val currencyInteractor: CurrencyInteractor
) : ViewModel() {
    private val _currencies: MutableLiveData<List<Currency>> = MutableLiveData()
    val currencies: LiveData<List<Currency>> get() = _currencies

    init {
        loadCurrencies()
    }

    private fun loadCurrencies() {
        viewModelScope.launch {
            currencyInteractor.getCurrencyList().collect { currencyList ->
                _currencies.value = currencyList
            }
        }
    }
}
