package com.xpns.data.services

import com.xpns.data.model.RepositoriesResponse
import com.xpns.data.model.Subscribers
import io.reactivex.Single
import retrofit2.http.*


interface ApiService {
    @GET("/search/repositories")
    fun searchRepository(@Query("q") query: String): Single<RepositoriesResponse>

    @GET
    fun fetchRepositorySubscribers(@Url url: String): Single<List<Subscribers>>

    @POST("exec?action=insert")
    fun saveExpens(@Query("itemName") amount: String, @Query("brand") expenseCategory: String):  Single<String>

}