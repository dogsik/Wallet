package com.example.wallet.data.repository

import com.example.wallet.data.local.LocalCurrencyRateDataSource
import com.example.wallet.data.mapper.CurrencyRateMapper
import com.example.wallet.data.model.CurrencyRateModel
import com.example.wallet.domain.repository.CurrencyRateRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

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

    private inline fun <T, R> T.resultOf(block: T.() -> R): Result<R> {
        return try {
            Result.success(block())
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.failure(Exception("Fetching error"))
        }
    }
}
