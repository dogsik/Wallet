package com.example.wallet.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingStore {
    suspend fun saveCurrency(currency: String)
    fun getCurrency(): Flow<String>
}
