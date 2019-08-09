package com.hush.data.services

import com.hush.data.model.Portfolio
import io.reactivex.Single
import retrofit2.http.GET


interface ApiService {

    @GET("get-portfolio")
    fun getPortfolio(): Single<List<Portfolio>>

}