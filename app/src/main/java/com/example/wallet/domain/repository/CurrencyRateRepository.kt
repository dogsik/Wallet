package com.example.wallet.domain.repository

import com.example.wallet.data.model.CurrencyRateModel
import kotlinx.coroutines.flow.Flow

interface CurrencyRateRepository {
    fun getCurrencyRate(code: String): Flow<Result<CurrencyRateModel>>
}
