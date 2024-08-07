package com.example.wallet.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.wallet.domain.repository.SettingStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
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

    override suspend fun saveCurrency(currency: String) {
        withContext(Dispatchers.IO) {
            sharedPreferences.edit().putString(KEY_SELECTED_CURRENCY, currency).apply()
        }
    }

    override fun getCurrency(): Flow<String> {
        return flow {
            emit(sharedPreferences.getString(KEY_SELECTED_CURRENCY, DEFAULT_CURRENCY)
                ?: DEFAULT_CURRENCY)
        }.flowOn(Dispatchers.IO)
    }
}
