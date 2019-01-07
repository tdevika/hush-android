package com.xpns.data.services

import io.reactivex.Single
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {
    @POST("exec?action=insert")
    fun saveExpns(@Query("amount") amount: String, @Query("category") category: String, @Query("date") date: String, @Query("note") note: String): Single<String>

}