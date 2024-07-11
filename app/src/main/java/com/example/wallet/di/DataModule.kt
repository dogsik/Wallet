package com.example.wallet.di

import com.example.wallet.domain.interactor.GetAssetByIdInteractor
import com.example.wallet.domain.interactor.GetAssetListInteractor
import com.example.wallet.domain.repository.AssetRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {
    @Provides
    fun provideGetAssetListInteractor(assetRepository: AssetRepository): GetAssetListInteractor {
        return GetAssetListInteractor(assetRepository)
    }

    @Provides
    fun provideGetAssetByIdInteractor(assetRepository: AssetRepository): GetAssetByIdInteractor {
        return GetAssetByIdInteractor(assetRepository)
    }
}
