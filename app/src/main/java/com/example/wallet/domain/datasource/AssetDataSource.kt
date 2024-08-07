package com.example.wallet.domain.datasource

import com.example.wallet.domain.entity.Asset

interface AssetDataSource {
    suspend fun getAssetList(): List<Asset>
    suspend fun deleteAsset(id: Int)
}
