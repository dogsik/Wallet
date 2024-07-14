package com.example.wallet.data.local

import com.example.wallet.data.defaults.DefaultCurrencies
import com.example.wallet.domain.datasource.CurrencyDataSource
import com.example.wallet.domain.entity.Currency
import javax.inject.Inject

class DefaultCurrencyDataSource @Inject constructor() : CurrencyDataSource {
    override fun getCurrencyList(): List<Currency> {
        return DefaultCurrencies.getCurrencies()
    }
}
