package com.example.wallet.data.model

data class CurrencyRateModel(
    val date: String,
    val abbreviation: String,
    val scale: Int,
    val rate: Double
)
