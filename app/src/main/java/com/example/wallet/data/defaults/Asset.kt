package com.example.wallet.data.defaults

import java.util.Date

data class Asset(
    val id: Int,
    val name: String,
    val value: Double,
    val currency: Int
)
object AssetData{
    fun getAssets() = listOf(
        Asset(1, "ABC", 12.12, 1)
    )
}
