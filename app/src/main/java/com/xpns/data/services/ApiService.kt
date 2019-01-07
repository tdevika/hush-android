package com.xpns.data.services

import com.xpns.data.model.RepositoriesResponse
import com.xpns.data.model.Subscribers
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url


interface ApiService {
    @GET("/search/repositories")
    fun searchRepository(@Query("q") query: String): Single<RepositoriesResponse>

    @GET
    fun fetchRepositorySubscribers(@Url url: String): Single<List<Subscribers>>

    @POST("exec?action=insert")
    fun saveExpns(@Query("amount") amount: String, @Query("category") category: String, @Query("date") date: String, @Query("note") note: String): Single<String>

}