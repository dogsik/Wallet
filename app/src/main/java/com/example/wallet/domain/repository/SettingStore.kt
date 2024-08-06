package com.example.wallet.domain.repository

interface SettingStore {
    suspend fun saveCurrency(currency: String)
    suspend fun getCurrency(): String
}
