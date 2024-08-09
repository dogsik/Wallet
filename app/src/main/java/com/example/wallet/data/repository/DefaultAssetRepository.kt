package com.example.wallet.data.repository

import com.example.wallet.domain.datasource.AssetDataSource
import com.example.wallet.domain.entity.Asset
import com.example.wallet.domain.repository.AssetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultAssetRepository @Inject constructor(
    private val dataSource: AssetDataSource
) : AssetRepository {
    override fun getAssets(): Flow<List<Asset>> {
        return flow {
            emit(dataSource.getAssetList())
        }.flowOn(Dispatchers.IO)
    }

    override fun getAssetById(id: Int): Flow<Asset?> {
        return flow {
            emit(dataSource.getAssetList().firstOrNull() { it.id == id })
        }.flowOn(Dispatchers.IO)
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
