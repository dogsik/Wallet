package com.example.wallet.data.repository

import com.example.wallet.domain.datasource.AssetDataSource
import com.example.wallet.domain.entity.Asset
import com.example.wallet.domain.repository.AssetRepository
import javax.inject.Inject

class DefaultAssetRepository @Inject constructor(
    private val dataSource: AssetDataSource
) : AssetRepository {
    override fun getAssets(): List<Asset> {
        return dataSource.getAssetList()
    }

    override fun getAssetById(id: Int): Asset {
        return dataSource.getAssetList().first { it.id == id }
    }

    override fun deleteAsset(id: Int) {
        TODO("Not yet implemented")
    }

    override fun addAsset(asset: Asset) {
        TODO("Not yet implemented")
    }

    override fun updateAsset(id: Int, asset: Asset) {
        TODO("Not yet implemented")
    }
}
