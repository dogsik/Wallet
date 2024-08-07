package com.example.wallet.domain.repository

import com.example.wallet.domain.entity.Asset
import kotlinx.coroutines.flow.Flow

interface AssetRepository {
    fun getAssets(): Flow<List<Asset>>
    fun getAssetById(id: Int): Flow<Asset?>
    suspend fun deleteAsset(id: Int)
    fun addAsset(asset: Asset)
    fun updateAsset(id: Int, asset: Asset)
}
