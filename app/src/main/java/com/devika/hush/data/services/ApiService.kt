package com.devika.hush.data.services

import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.model.Stock
import com.devika.hush.data.model.WatchList
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface ApiService {
    @GET("get-portfolio")
    suspend fun getPortfolio(): List<Portfolio>

    @GET("get-bhav")
    suspend fun getStocks(): List<Stock>

    @GET("get-watchlist")
    suspend fun getWatchList(): List<WatchList>

    @PUT("add-to-watchlist")
    suspend fun addToWatchList(@Body stock: WatchList)

    @DELETE("delete-from-watchlist")
    suspend fun deleteWatchList(@Query("symbol") symbol: String)
}
