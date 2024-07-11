package com.example.wallet.domain.interactor

import com.example.wallet.domain.entity.Asset
import com.example.wallet.domain.repository.AssetRepository

class GetAssetByIdInteractor(
    private val assetRepository: AssetRepository
) {
    fun execute(id: Int): Asset {
        return assetRepository.getAssetById(id)
    }
}
