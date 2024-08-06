package com.example.wallet.domain.repository

import com.example.wallet.domain.entity.Asset

interface AssetRepository {
    fun getAssets(): List<Asset>
    fun getAssetById(id: Int): Asset?
    suspend fun deleteAsset(id: Int)
    fun addAsset(asset: Asset)
    fun updateAsset(id: Int, asset: Asset)
}
