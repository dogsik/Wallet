package com.example.wallet.data.repository

import com.example.wallet.domain.datasource.CurrencyDataSource
import com.example.wallet.domain.entity.Currency
import com.example.wallet.domain.repository.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DefaultCurrencyRepository @Inject constructor(
    private val dataSource: CurrencyDataSource
) : CurrencyRepository {
    override fun getCurrencies(): Flow<List<Currency>> {
        return flow {
            emit(dataSource.getCurrencyList())
        }.flowOn(Dispatchers.IO)
    }
}
