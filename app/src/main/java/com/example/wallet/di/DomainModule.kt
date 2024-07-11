package com.example.wallet.di

import com.example.wallet.data.AssetDataSource
import com.example.wallet.data.local.DefaultAssetDataSource
import com.example.wallet.domain.repository.AssetRepository
import com.example.wallet.domain.repository.impl.DefaultAssetRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    @Singleton
    fun provideAssetListRepository(dataSource: AssetDataSource): AssetRepository {
        return DefaultAssetRepository(dataSource = dataSource)
    }

    @Provides
    @Singleton
    fun provideAssetListDataSource(): AssetDataSource {
        return DefaultAssetDataSource()
    }
}
