package com.example.wallet.domain.repository

import com.example.wallet.data.model.CurrencyRateModel

interface CurrencyRateRepository {
    suspend fun getCurrencyRate(code: String): Result<CurrencyRateModel>
}
