package com.example.wallet.domain.entity

import java.math.BigDecimal
import java.time.LocalDate

enum class Currency(val currencyName: String) {
    USD("USD"),
    EUR("EUR"),
    CNY("CNY"),
    RUB("RUB"),
    BYN("BYN")
}

data class Meta(
    val country: String
)

abstract class Asset(
    open val id: Int,
    open val name: String,
    open val purchasePrice: BigDecimal,
    open val currency: Currency,
    open val meta: Meta
)

data class Stock(
    override val id: Int,
    override val name: String,
    override val purchasePrice: BigDecimal,
    override val currency: Currency,
    override val meta: Meta,
    val dividend: BigDecimal,
    val paymentDate: LocalDate
) : Asset(id, name, purchasePrice, currency, meta)

data class Bond(
    override val id: Int,
    override val name: String,
    override val purchasePrice: BigDecimal,
    override val currency: Currency,
    override val meta: Meta,
    val profitability: BigDecimal,
    val maturityDate: LocalDate
) : Asset(id, name, purchasePrice, currency, meta)

data class Cash(
    override val id: Int,
    override val name: String,
    override val purchasePrice: BigDecimal,
    override val currency: Currency,
    override val meta: Meta,
    val salePrice: BigDecimal
) : Asset(id, name, purchasePrice, currency, meta)
