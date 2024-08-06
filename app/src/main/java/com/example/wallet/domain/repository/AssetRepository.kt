package com.example.wallet.domain.repository

import com.example.wallet.domain.entity.Asset

interface AssetRepository {
    suspend fun getAssets(): List<Asset>
    suspend fun getAssetById(id: Int): Asset?
    fun deleteAsset(id: Int)
    fun addAsset(asset: Asset)
    fun updateAsset(id: Int, asset: Asset)
}
