package com.example.wallet.domain.repository

import com.example.wallet.domain.entity.Currency
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    fun getCurrencies(): Flow<List<Currency>>
}
