package com.example.wallet.domain.interactor

import com.example.wallet.domain.entity.Asset
import com.example.wallet.domain.repository.AssetRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetInteractor @Inject constructor(
    private val assetRepository: AssetRepository
) {
    fun getAssetById(id: Int): Result<Asset> {
        return try {
            val assetObject = assetRepository.getAssetById(id)
            if (assetObject != null) {
                Result.success(assetObject)
            } else {
                Result.failure(Exception("Object not found"))
            }
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    fun getAssetList() = assetRepository.getAssets()
}
