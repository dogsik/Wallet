package com.example.wallet.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.wallet.domain.repository.SettingStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultSettingStore @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : SettingStore {
    companion object {
        private val KEY_SELECTED_CURRENCY = stringPreferencesKey("selected_currency")
        private const val DEFAULT_CURRENCY = "USD"
    }

    override suspend fun saveCurrency(currency: String) {
        withContext(Dispatchers.IO) {
            dataStore.edit {
                it[KEY_SELECTED_CURRENCY] = currency
            }
        }
    }

    override fun getCurrency(): Flow<String> =
        dataStore.data.map { preferences ->
            preferences[KEY_SELECTED_CURRENCY] ?: DEFAULT_CURRENCY
        }
}
