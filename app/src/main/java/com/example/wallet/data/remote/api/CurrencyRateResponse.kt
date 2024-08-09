package com.example.wallet.data.remote.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyRateResponse(
    @SerialName("Date")
    val date: String,
    @SerialName("Cur_Abbreviation")
    val abbreviation: String,
    @SerialName("Cur_Scale")
    val scale: Int,
    @SerialName("Cur_OfficialRate")
    val rate: Double
)
