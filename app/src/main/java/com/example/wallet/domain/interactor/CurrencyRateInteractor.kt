package com.example.wallet.domain.interactor

import com.example.wallet.data.model.CurrencyRateModel
import com.example.wallet.domain.repository.CurrencyRateRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrencyRateInteractor @Inject constructor(
    private val currencyRateRepository: CurrencyRateRepository
) {
    suspend fun getCurrencyRate(code: String): Result<CurrencyRateModel> {
        return currencyRateRepository.getCurrencyRate(code)
    }
}
