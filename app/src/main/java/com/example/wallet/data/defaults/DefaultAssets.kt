package com.example.wallet.data.defaults

import com.example.wallet.domain.entity.Bond
import com.example.wallet.domain.entity.Cash
import com.example.wallet.domain.entity.Currency
import com.example.wallet.domain.entity.Meta
import com.example.wallet.domain.entity.Stock
import java.math.BigDecimal
import java.time.LocalDate

object DefaultAssets {
    private val assetList = mutableListOf(
        Stock(
            id = 1,
            name = "PKNORLEN",
            purchasePrice = BigDecimal(65.80),
            currency = Currency.USD,
            meta = Meta("Poland"),
            dividend = BigDecimal(4.15),
            paymentDate = LocalDate.of(2024, 12, 20)
        ),
        Stock(
            id = 2,
            name = "NVIDIA Corporation",
            purchasePrice = BigDecimal(134.57),
            currency = Currency.USD,
            meta = Meta("USA"),
            dividend = BigDecimal(0.01),
            paymentDate = LocalDate.of(2024, 11, 6)
        ),
        Bond(
            id = 3,
            name = "RGBI",
            purchasePrice = BigDecimal(105.16),
            currency = Currency.RUB,
            meta = Meta("Russia"),
            profitability = BigDecimal(15.92),
            maturityDate = LocalDate.of(2024, 9, 1)
        ),
        Cash(
            id = 4,
            name = "1 EUR",
            purchasePrice = BigDecimal(3.4692),
            currency = Currency.BYN,
            meta = Meta("Belarus"),
            salePrice = BigDecimal(3.4654)
        ),
        Cash(
            id = 5,
            name = "1 USD",
            purchasePrice = BigDecimal(3.21),
            currency = Currency.BYN,
            meta = Meta("Belarus"),
            salePrice = BigDecimal(3.202)
        ),
        Cash(
            id = 6,
            name = "100 RUB",
            purchasePrice = BigDecimal(3.6385),
            currency = Currency.BYN,
            meta = Meta("Belarus"),
            salePrice = BigDecimal(3.615)
        ),
        Cash(
            id = 7,
            name = "1 CNY",
            purchasePrice = BigDecimal(7.269),
            currency = Currency.BYN,
            meta = Meta("Belarus"),
            salePrice = BigDecimal(7.3007)
        )
    )

    suspend fun getAssets() = assetList

    suspend fun deleteAsset(id: Int) {
        assetList.removeAt(id)
    }
}
