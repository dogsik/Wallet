package com.example.wallet.data

import com.example.wallet.domain.entity.Asset

interface AssetDataSource {
    fun getAssetList(): List<Asset>
}