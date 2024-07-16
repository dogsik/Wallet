package com.example.wallet.domain.interactor

import com.example.wallet.domain.repository.CurrencyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrencyInteractor @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    fun getCurrencyList() = currencyRepository.getCurrencies()
}
