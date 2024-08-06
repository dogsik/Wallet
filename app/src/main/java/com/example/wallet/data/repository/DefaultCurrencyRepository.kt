package com.example.wallet.data.repository

import com.example.wallet.domain.datasource.CurrencyDataSource
import com.example.wallet.domain.entity.Currency
import com.example.wallet.domain.repository.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultCurrencyRepository @Inject constructor(
    private val dataSource: CurrencyDataSource
) : CurrencyRepository {
    override suspend fun getCurrencies(): List<Currency> {
        return withContext(Dispatchers.IO) { dataSource.getCurrencyList() }
    }
}
