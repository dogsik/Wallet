package com.example.wallet.domain.datasource

import com.example.wallet.domain.entity.Currency

interface CurrencyDataSource {
    fun getCurrencyList(): List<Currency>
}
