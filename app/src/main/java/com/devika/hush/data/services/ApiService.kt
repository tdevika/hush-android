package com.devika.hush.data.services

import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.model.Stock
import com.devika.hush.data.model.StockDetails
import com.devika.hush.data.model.WatchList
import retrofit2.http.*

interface ApiService {
    @GET("get-portfolio")
    suspend fun getPortfolio(): List<Portfolio>

    @GET("get-watchlist")
    suspend fun getWatchList(): List<WatchList>

    @GET("get-stocks")
    suspend fun getStocks(): List<Stock>

    @PUT("add-to-watchlist")
    suspend fun addToWatchList(@Body stock: WatchList)

    @DELETE("delete-from-watchlist")
    suspend fun deleteWatchList(@Query("symbol") symbol: String)

    @GET("get-stock-details")
    suspend fun getStockDetails(@Query("symbol") symbol: String): StockDetails
}
