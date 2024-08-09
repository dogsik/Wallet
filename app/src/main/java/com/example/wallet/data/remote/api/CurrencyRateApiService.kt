package com.example.wallet.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyRateApiService {
    @GET("/exrates/rates/{code}?parammode=2")
    suspend fun getCurrencyRate(@Path("code") code: String): CurrencyRateResponse
}
