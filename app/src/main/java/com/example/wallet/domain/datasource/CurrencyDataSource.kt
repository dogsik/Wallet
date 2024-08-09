package com.example.wallet.domain.datasource

import com.example.wallet.domain.entity.Currency

interface CurrencyDataSource {
    suspend fun getCurrencyList(): List<Currency>
}
