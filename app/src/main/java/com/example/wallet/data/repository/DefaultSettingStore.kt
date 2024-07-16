package com.example.wallet.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.wallet.domain.repository.SettingStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DefaultSettingStore @Inject constructor(
    @ApplicationContext context: Context
) : SettingStore {
    companion object {
        private const val PREFS_NAME = "currency_settings"
        private const val KEY_SELECTED_CURRENCY = "selected_currency"
        private const val DEFAULT_CURRENCY = "usd"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveCurrency(currency: String) {
        sharedPreferences.edit().putString(KEY_SELECTED_CURRENCY, currency).apply()
    }

    override fun getCurrency(): String {
        return sharedPreferences.getString(KEY_SELECTED_CURRENCY, DEFAULT_CURRENCY)
            ?: DEFAULT_CURRENCY
    }
}
