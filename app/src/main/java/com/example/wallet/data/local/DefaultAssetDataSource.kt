package com.example.wallet.data.local

import com.example.wallet.data.defaults.DefaultAssets
import com.example.wallet.domain.datasource.AssetDataSource
import com.example.wallet.domain.entity.Asset
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultAssetDataSource @Inject constructor() : AssetDataSource {
    override suspend fun getAssetList(): List<Asset> {
        return withContext(Dispatchers.IO) {
            DefaultAssets.getAssets()
        }
    }

    override suspend fun deleteAsset(id: Int) {
        withContext(Dispatchers.IO) { DefaultAssets.deleteAsset(id) }
    }
}
