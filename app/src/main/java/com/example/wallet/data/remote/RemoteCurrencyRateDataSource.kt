package com.example.wallet.data.remote

import com.example.wallet.data.remote.api.CurrencyRateApiService
import com.example.wallet.data.remote.api.CurrencyRateResponse
import javax.inject.Inject

class RemoteCurrencyRateDataSource @Inject constructor(
    private val currencyRateApiService: CurrencyRateApiService
) {
    suspend fun getCurrencyRate(code: String): CurrencyRateResponse {
        return currencyRateApiService.getCurrencyRate(code)
    }
}
