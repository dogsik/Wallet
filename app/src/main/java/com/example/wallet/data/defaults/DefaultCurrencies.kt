package com.example.wallet.data.defaults

import com.example.wallet.domain.entity.Currency

object DefaultCurrencies {
    private val currencyArray = Currency.entries.toTypedArray()
    suspend fun getCurrencies() = currencyArray.toList()
}
