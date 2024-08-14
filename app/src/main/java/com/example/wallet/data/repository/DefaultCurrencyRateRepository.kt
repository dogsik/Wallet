package com.example.wallet.data.repository

import com.example.wallet.data.local.LocalCurrencyRateDataSource
import com.example.wallet.data.local.db.CurrencyRateDb
import com.example.wallet.data.local.db.toModel
import com.example.wallet.data.model.CurrencyRateModel
import com.example.wallet.data.remote.RemoteCurrencyRateDataSource
import com.example.wallet.data.remote.api.toDb
import com.example.wallet.domain.repository.CurrencyRateRepository
import com.example.wallet.utils.resultOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject

class DefaultCurrencyRateRepository @Inject constructor(
    private val localCurrencyRateDataSource: LocalCurrencyRateDataSource,
    private val remoteCurrencyRateDataSource: RemoteCurrencyRateDataSource
) : CurrencyRateRepository {
    companion object {
        private const val DATE_START_PARSING = 0
        private const val DATE_END_PARSING = 10
    }

    override suspend fun getCurrencyRate(code: String): Result<CurrencyRateModel> {
        return withContext(Dispatchers.IO) {
            try {
                val dbCurrencyRateDb = localCurrencyRateDataSource.getCurrencyRate(code)
                if (dbCurrencyRateDb != null && LocalDate.parse(
                        dbCurrencyRateDb.date.subSequence(DATE_START_PARSING, DATE_END_PARSING)
                    ).isToday()
                ) {
                    resultOf {
                        dbCurrencyRateDb.toModel()
                    }
                } else {
                    resultOf {
                        getCurrencyRateFromNetworkAndSynchronize(code).toModel()
                    }
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    private suspend fun getCurrencyRateFromNetworkAndSynchronize(code: String): CurrencyRateDb {
        val currencyRate = remoteCurrencyRateDataSource.getCurrencyRate(code).toDb()
        localCurrencyRateDataSource.addCurrencyRate(currencyRate)
        return currencyRate
    }

    private fun LocalDate?.isToday(): Boolean {
        return this?.isEqual(LocalDate.now()) ?: false
    }
}
