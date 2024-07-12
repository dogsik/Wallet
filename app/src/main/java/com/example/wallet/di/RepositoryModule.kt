package com.example.wallet.di

import com.example.wallet.data.local.DefaultAssetDataSource
import com.example.wallet.data.repository.DefaultAssetRepository
import com.example.wallet.domain.datasource.AssetDataSource
import com.example.wallet.domain.repository.AssetRepository
import dagger.Binds
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.Module
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAssetRepository(assetRepository: DefaultAssetRepository): AssetRepository

    @Binds
    @Singleton
    abstract fun bindDataSource(dataSource: DefaultAssetDataSource): AssetDataSource
}
