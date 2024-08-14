package com.example.wallet.data.remote.api

import com.example.wallet.data.local.db.CurrencyRateDb
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

fun CurrencyRateResponse.toDb(): CurrencyRateDb {
    return CurrencyRateDb(
        date = this.date,
        abbreviation = this.abbreviation,
        scale = this.scale,
        rate = this.rate
    )
}
