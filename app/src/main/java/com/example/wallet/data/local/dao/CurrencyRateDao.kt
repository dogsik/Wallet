package com.example.wallet.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.wallet.data.local.db.CurrencyRateDb

@Dao
interface CurrencyRateDao {
    @Insert
    suspend fun createCurrencyRate(currencyRate: CurrencyRateDb)

    @Query(
        "SELECT * FROM currency_rate WHERE abbreviation = (:abbreviation) ORDER BY id DESC LIMIT 1"
    )
    suspend fun selectCurrencyRate(abbreviation: String): CurrencyRateDb
}
