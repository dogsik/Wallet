package com.example.wallet.data.repository

import com.example.wallet.domain.datasource.AssetDataSource
import com.example.wallet.domain.entity.Asset
import com.example.wallet.domain.repository.AssetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultAssetRepository @Inject constructor(
    private val dataSource: AssetDataSource
) : AssetRepository {
    override fun getAssets(): List<Asset> {
        return dataSource.getAssetList()
    }

    override fun getAssetById(id: Int): Asset? {
        return dataSource.getAssetList().firstOrNull() { it.id == id }
    }

    override suspend fun deleteAsset(id: Int) {
        withContext(Dispatchers.IO) {
            dataSource.deleteAsset(id)
        }
    }

    override fun addAsset(asset: Asset) {
        TODO("Not yet implemented")
    }

    override fun updateAsset(id: Int, asset: Asset) {
        TODO("Not yet implemented")
    }
}
