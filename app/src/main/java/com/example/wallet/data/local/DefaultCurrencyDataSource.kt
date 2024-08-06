package com.example.wallet.data.local

import com.example.wallet.data.defaults.DefaultCurrencies
import com.example.wallet.domain.datasource.CurrencyDataSource
import com.example.wallet.domain.entity.Currency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultCurrencyDataSource @Inject constructor() : CurrencyDataSource {
    override suspend fun getCurrencyList(): List<Currency> {
        return withContext(Dispatchers.IO) { DefaultCurrencies.getCurrencies() }
    }
}
