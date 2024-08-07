package com.example.wallet.domain.interactor

import com.example.wallet.domain.repository.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrencyInteractor @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    fun getCurrencyList() = currencyRepository.getCurrencies().flowOn(Dispatchers.IO)
}
