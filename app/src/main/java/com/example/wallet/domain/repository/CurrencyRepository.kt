package com.example.wallet.domain.repository

import com.example.wallet.domain.entity.Currency

interface CurrencyRepository {
    suspend fun getCurrencies(): List<Currency>
}
