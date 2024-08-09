package com.example.wallet.domain.repository

import com.example.wallet.data.remote.api.CurrencyRateResponse

interface CurrencyRateRepository {
    suspend fun getCurrencyRate(code: String): CurrencyRateResponse
}
