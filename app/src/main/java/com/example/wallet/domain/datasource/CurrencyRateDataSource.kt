package com.example.wallet.domain.datasource

interface CurrencyRateDataSource {
    fun getCurrencyRate(code: String)
}
