package com.devika.hush.data.services

import com.devika.hush.data.model.Stocks
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT

interface ApiService {
    @GET("get-portfolio")
    suspend fun getPortfolioList(): List<Stocks>

    @GET("get-bhav")
    suspend fun getAllStocksList(): List<Stocks>

    @GET("get-watchlist")
    suspend fun getWatchList(): List<Stocks>?

    @PUT("add-watchlist-item")
    suspend fun addToWatchList(@Body stocks: Stocks)

    @DELETE("delete-from-watchlist")
    suspend fun deleteWatchList(stocks: Stocks)
}