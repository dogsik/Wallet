package com.example.wallet.domain.interactor

import com.example.wallet.domain.repository.AssetRepository
import javax.inject.Inject

class AssetInteractor @Inject constructor(
    private val assetRepository: AssetRepository
) {
    fun getAssetById(id: Int) = assetRepository.getAssetById(id)

    fun getAssetList() = assetRepository.getAssets()
}
