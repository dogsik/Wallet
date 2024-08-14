package com.example.wallet.data.repository

import com.example.wallet.data.local.LocalCurrencyRateDataSource
import com.example.wallet.data.mapper.CurrencyRateMapper
import com.example.wallet.data.model.CurrencyRateModel
import com.example.wallet.domain.repository.CurrencyRateRepository
import com.example.wallet.utils.resultOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultCurrencyRateRepository @Inject constructor(
    private val localCurrencyRateDataSource: LocalCurrencyRateDataSource
) : CurrencyRateRepository {
    override suspend fun getCurrencyRate(code: String): Result<CurrencyRateModel> {
        return withContext(Dispatchers.IO) {
            resultOf {
                CurrencyRateMapper.currencyRateDbToModel(
                    localCurrencyRateDataSource.getCurrencyRate(code)
                )
            }
        }
    }
}
