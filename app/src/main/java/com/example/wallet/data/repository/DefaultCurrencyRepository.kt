package com.example.wallet.data.repository

import com.example.wallet.domain.datasource.CurrencyDataSource
import com.example.wallet.domain.entity.Currency
import com.example.wallet.domain.repository.CurrencyRepository
import javax.inject.Inject

class DefaultCurrencyRepository @Inject constructor(
    private val dataSource: CurrencyDataSource
) : CurrencyRepository {
    override fun getCurrencies(): List<Currency> {
        return dataSource.getCurrencyList()
    }
}
