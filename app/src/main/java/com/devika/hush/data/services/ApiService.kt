package com.devika.hush.data.services

import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.model.Stocks
import retrofit2.http.*

interface ApiService {
    @GET("get-portfolio")
    suspend fun getPortfolio(): List<Portfolio>

    @GET("get-bhav")
    suspend fun getStocks(): List<Stocks>

    @GET("get-watchlist")
    suspend fun getWatchList(): List<Stocks>?

    @PUT("add-to-watchlist")
    suspend fun addToWatchList(@Body stocks: Stocks)

    @DELETE("delete-from-watchlist")
    suspend fun deleteWatchList(@Query("symbol") symbol: String)
}