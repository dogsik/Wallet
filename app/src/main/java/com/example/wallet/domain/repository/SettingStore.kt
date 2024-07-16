package com.example.wallet.domain.repository

interface SettingStore {
    fun saveCurrency(currency: String)
    fun getCurrency(): String
}
