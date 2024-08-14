package com.example.wallet.di

import android.content.Context
import androidx.room.Room
import com.example.wallet.data.local.AppDatabase
import com.example.wallet.data.local.dao.CurrencyRateDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideApplicationDb(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "wallet_db"
        ).build()
    }

    @Provides
    fun provideCurrencyRateDao(database: AppDatabase): CurrencyRateDao {
        return database.currencyRateDao()
    }
}
