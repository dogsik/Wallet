package com.example.wallet.domain.interactor

import com.example.wallet.data.model.CurrencyRateModel
import com.example.wallet.domain.repository.CurrencyRateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrencyRateInteractor @Inject constructor(
    private val currencyRateRepository: CurrencyRateRepository
) {
    fun getCurrencyRate(code: String): Flow<Result<CurrencyRateModel>> {
        return currencyRateRepository.getCurrencyRate(code)
    }
}
