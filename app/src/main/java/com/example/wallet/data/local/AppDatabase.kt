package com.example.wallet.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wallet.data.local.dao.CurrencyRateDao
import com.example.wallet.data.local.db.CurrencyRateDb
import javax.inject.Singleton

@Database(
    entities = [CurrencyRateDb::class],
    version = 1
)
@Singleton
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyRateDao(): CurrencyRateDao
}
