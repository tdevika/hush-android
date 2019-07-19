package com.hush.data.services

import com.hush.data.model.HushItems
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {
    @POST("exec?action=insert")
    fun saveExpns(@Query("amount") amount: String, @Query("category") category: String, @Query("date") date: String, @Query("note") note: String): Single<String>

    @GET("exec?action=getItems")
    fun getExpenses(): Single<HushItems>

}