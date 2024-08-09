package com.example.wallet.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency_rate")
data class CurrencyRateDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "abbreviation")
    val abbreviation: String,
    @ColumnInfo(name = "scale")
    val scale: Int,
    @ColumnInfo("rate")
    val rate: Double
)
