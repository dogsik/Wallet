package com.example.wallet.data.local

import com.example.wallet.data.defaults.DefaultAssets
import com.example.wallet.domain.datasource.AssetDataSource
import com.example.wallet.domain.entity.Asset
import javax.inject.Inject

class DefaultAssetDataSource @Inject constructor() : AssetDataSource {
    override fun getAssetList(): List<Asset> {
        return DefaultAssets.getAssets()
    }
}
