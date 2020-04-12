package com.devika.hush.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "portfolio")
data class Portfolio(
    @SerializedName("avg_cost")
    val avgCost: String,
    @SerializedName("close_price")
    val closePrice: String,
    val eps: String,
    @SerializedName("hi_52_wk")
    val hi52Wk: String,
    val index: String,
    @SerializedName("lo_52_wk")
    val lo52Wk: String,
    val pe: String,
    @SerializedName("prev_close_price")
    val prevClosePrice: String,
    val quantity: String,
    val sector: String,
    @PrimaryKey val security: String,
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
    @SerializedName("close_price")
    val closePrice: String,
    @SerializedName("hi_52_wk")
    val hi52Wk: String,
    val index: String,
    @SerializedName("lo_52_wk")
    val lo52Wk: String,
    @SerializedName("prev_close_price")
    val prevClosePrice: String,
    @PrimaryKey val security: String,
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









