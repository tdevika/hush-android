package com.devika.hush.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "portfolio")
data class Portfolio(
    @PrimaryKey val security: String,
    val avgCost: String,
    val closePrice: String,
    val eps: String,
    val hi52Wk: String,
    val index: String,
    val lo52Wk: String,
    val pe: String,
    val prevClosePrice: String,
    val quantity: String,
    val sector: String,
    val symbol: String

) {

    fun dayChange(): Double {
        return if (closePrice.isNotEmpty()) "%.2f".format(closePrice.toFloat() - prevClosePrice.toFloat()).toDouble() else 00.00
    }

    fun dayChangePercentage(): Float {
        return if (closePrice.isNotEmpty() && prevClosePrice.isNotEmpty()) "%.2f".format(((closePrice.toFloat() - prevClosePrice.toFloat()) / closePrice.toFloat()) * 100)
            .toFloat() else 0.0f
    }

    fun netChangePercentage(): Float {
        return if (closePrice.isNotEmpty() && avgCost.isNotEmpty()) "%.2f".format(((closePrice.toFloat() - avgCost.toFloat()) / avgCost.toFloat()) * 100)
            .toFloat() else 0.0f
    }

}

@Entity(tableName = "stocks")
data class Stocks(
    @PrimaryKey val security: String,
    val closePrice: String,
    val hi52Wk: String,
    val index: String,
    val lo52Wk: String,
    val prevClosePrice: String,
    val symbol: String,
    val date: String? = null,
    var isStockAddedToWatchList: Boolean = true
) {

    fun dayChange(): Double {
        return if (closePrice.isNotEmpty()) "%.2f".format(closePrice.toFloat() - prevClosePrice.toFloat()).toDouble() else 00.00

    }

    fun dayChangePercentage(): Float {
        return if (closePrice.isNotEmpty() && prevClosePrice.isNotEmpty()) "%.2f".format(((closePrice.toFloat() - prevClosePrice.toFloat()) / closePrice.toFloat()) * 100)
            .toFloat() else 0.0f
    }
}









