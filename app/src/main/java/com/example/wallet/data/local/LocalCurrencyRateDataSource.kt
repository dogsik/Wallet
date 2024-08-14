package com.example.wallet.data.local

import com.example.wallet.data.local.dao.CurrencyRateDao
import com.example.wallet.data.local.db.CurrencyRateDb
import com.example.wallet.domain.datasource.CurrencyRateDataSource
import javax.inject.Inject

class LocalCurrencyRateDataSource @Inject constructor(
    private val currencyRateDao: CurrencyRateDao
) : CurrencyRateDataSource {
    override suspend fun getCurrencyRate(code: String): CurrencyRateDb {
        return currencyRateDao.selectCurrencyRate(code)
    }

    override suspend fun addCurrencyRate(currencyRateDb: CurrencyRateDb) {
        currencyRateDao.createCurrencyRate(currencyRateDb)
    }
}
