package com.example.wallet.data.repository

import com.example.wallet.data.local.LocalCurrencyRateDataSource
import com.example.wallet.data.local.db.CurrencyRateDb
import com.example.wallet.data.mapper.CurrencyRateMapper
import com.example.wallet.data.model.CurrencyRateModel
import com.example.wallet.data.remote.RemoteCurrencyRateDataSource
import com.example.wallet.domain.repository.CurrencyRateRepository
import com.example.wallet.utils.resultOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import javax.inject.Inject

class DefaultCurrencyRateRepository @Inject constructor(
    private val localCurrencyRateDataSource: LocalCurrencyRateDataSource,
    private val remoteCurrencyRateDataSource: RemoteCurrencyRateDataSource
) : CurrencyRateRepository {
    companion object {
        private var lastUpdated: LocalDateTime? = null
    }

    override suspend fun getCurrencyRate(code: String): Result<CurrencyRateModel> {
        return withContext(Dispatchers.IO) {
            if (lastUpdated == null || !isToday(lastUpdated)) {
                try {
                    lastUpdated = LocalDateTime.now()
                    resultOf {
                        CurrencyRateMapper.currencyRateDbToModel(
                            getCurrencyRateFromNetworkAndSynchronize(code)
                        )
                    }
                } catch (e: Exception) {
                    resultOf {
                        CurrencyRateMapper.currencyRateDbToModel(
                            localCurrencyRateDataSource.getCurrencyRate(code)
                        )
                    }
                }
            }
            resultOf {
                CurrencyRateMapper.currencyRateDbToModel(
                    localCurrencyRateDataSource.getCurrencyRate(code)
                )
            }
        }
    }

    private suspend fun getCurrencyRateFromNetworkAndSynchronize(code: String): CurrencyRateDb {
        val response = remoteCurrencyRateDataSource.getCurrencyRate(code)
        val currencyRate = CurrencyRateDb(
            date = response.date,
            abbreviation = response.abbreviation,
            scale = response.scale,
            rate = response.rate
        )
        localCurrencyRateDataSource.addCurrencyRate(currencyRate)
        return currencyRate
    }

    private fun isToday(dateTime: LocalDateTime?): Boolean {
        return dateTime?.toLocalDate()?.isEqual(LocalDateTime.now().toLocalDate()) ?: false
    }
}
