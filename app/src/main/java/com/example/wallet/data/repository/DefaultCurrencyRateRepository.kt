package com.example.wallet.data.repository

import com.example.wallet.data.remote.api.CurrencyRateResponse
import com.example.wallet.domain.repository.CurrencyRateRepository
import javax.inject.Inject

class DefaultCurrencyRateRepository @Inject constructor() : CurrencyRateRepository {
    override suspend fun getCurrencyRate(code: String): CurrencyRateResponse {
        TODO("Not yet implemented")
    }
}
