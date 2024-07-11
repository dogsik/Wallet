package com.example.wallet.data.local

import com.example.wallet.data.AssetDataSource
import com.example.wallet.data.defaults.DefaultAssets
import com.example.wallet.domain.entity.Asset

class DefaultAssetDataSource : AssetDataSource {
    override fun getAssetList(): List<Asset> {
        return DefaultAssets.getAssets()
    }
}
