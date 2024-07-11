package com.example.wallet.domain.interactor

import com.example.wallet.domain.repository.AssetRepository

class GetAssetListInteractor(
    private val assetRepository: AssetRepository
) {
    fun execute() = assetRepository.getAssets()
}
