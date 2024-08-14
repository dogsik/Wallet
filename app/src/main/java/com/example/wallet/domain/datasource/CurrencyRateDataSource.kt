package com.example.wallet.domain.datasource

import com.example.wallet.data.local.db.CurrencyRateDb

interface CurrencyRateDataSource {
    suspend fun getCurrencyRate(code: String): CurrencyRateDb
    suspend fun addCurrencyRate(currencyRateDb: CurrencyRateDb)
}
