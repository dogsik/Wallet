package com.example.wallet.domain.interactor

import com.example.wallet.domain.entity.Asset
import com.example.wallet.domain.repository.AssetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AssetInteractor @Inject constructor(
    private val assetRepository: AssetRepository
) {
    fun getAssetById(id: Int): Flow<Result<Asset>> {
        return assetRepository.getAssetById(id)
            .map { asset ->
                if (asset != null) {
                    Result.success(asset)
                } else {
                    Result.failure(Exception("Object not found"))
                }
            }
    }

    fun getAssetList() = assetRepository.getAssets().flowOn(Dispatchers.IO)

    suspend fun deleteAssetById(id: Int) {
        withContext(Dispatchers.IO) {
            assetRepository.deleteAsset(id)
        }
    }
}
