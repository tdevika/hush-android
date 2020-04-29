package com.devika.hush.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "portfolio")
data class Portfolio(
    @PrimaryKey val symbol: String,
    val security: String,
    val avgCost: Float,
    val closePrice: Float,
    val eps: Float,
    val hi52Wk: Float,
    val index: String,
    val lo52Wk: Float,
    val pe: Float,
    val prevClosePrice: Float,
    val quantity: Int,
    val sector: String

) {

    fun dayChangePercentage() = "%.2f".format(((closePrice - prevClosePrice) / closePrice) * 100).toFloat()

    fun netChangePercentage() = "%.2f".format(((closePrice - avgCost) / avgCost) * 100).toFloat()
}

@Entity(tableName = "stock")
data class Stock(
    @PrimaryKey val symbol: String,
    val security: String,
    val closePrice: Float,
    val hi52Wk: Float,
    val index: String,
    val lo52Wk: Float,
    val prevClosePrice: Float
    ) {

    fun dayChange() = "%.2f".format(closePrice - prevClosePrice).toFloat()

    fun dayChangePercentage() = "%.2f".format(((closePrice - prevClosePrice) / closePrice) * 100).toFloat()
}

@Entity
data class WatchList(
    @PrimaryKey val symbol: String,
    val price: Float,
    val date: String
)

// TODO: Remove this and perform query to get required field
data class DetailWatchList(
    @Embedded val watchList: WatchList,
    @Relation(
        parentColumn = "symbol",
        entityColumn = "symbol"
    )
    val stock: Stock
)
