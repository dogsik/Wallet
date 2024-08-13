package com.example.wallet.data.repository

import com.example.wallet.data.local.LocalCurrencyRateDataSource
import com.example.wallet.data.mapper.CurrencyRateMapper
import com.example.wallet.data.model.CurrencyRateModel
import com.example.wallet.domain.repository.CurrencyRateRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DefaultCurrencyRateRepository @Inject constructor(
    private val localCurrencyRateDataSource: LocalCurrencyRateDataSource
) : CurrencyRateRepository {
    override fun getCurrencyRate(code: String): Flow<Result<CurrencyRateModel>> {
        return flow {
            try {
                val currency = CurrencyRateMapper.currencyRateDbToModel(
                    localCurrencyRateDataSource.getCurrencyRate(code)
                )
                emit(Result.success(currency))
            } catch (e: Exception) {
                emit(Result.failure(Exception("Fetching error")))
            }
        }.flowOn(Dispatchers.IO)
    }
}
