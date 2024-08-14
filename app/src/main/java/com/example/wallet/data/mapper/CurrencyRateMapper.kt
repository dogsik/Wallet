package com.example.wallet.data.mapper

import com.example.wallet.data.local.db.CurrencyRateDb
import com.example.wallet.data.model.CurrencyRateModel

object CurrencyRateMapper {
    fun currencyRateDbToModel(currencyRateDb: CurrencyRateDb): CurrencyRateModel {
        return CurrencyRateModel(
            date = currencyRateDb.date,
            abbreviation = currencyRateDb.abbreviation,
            scale = currencyRateDb.scale,
            rate = currencyRateDb.rate
        )
    }
}
