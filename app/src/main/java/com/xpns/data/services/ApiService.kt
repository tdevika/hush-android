package com.xpns.data.services

import com.xpns.data.model.Xpns
import com.xpns.data.model.XpnsItems
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url


interface ApiService {
    @POST("exec?action=insert")
    fun saveExpns(@Query("amount") amount: String, @Query("category") category: String, @Query("date") date: String, @Query("note") note: String): Single<String>

    @GET("exec?action=getItems")
    fun getExpenses(): Single<XpnsItems>

}