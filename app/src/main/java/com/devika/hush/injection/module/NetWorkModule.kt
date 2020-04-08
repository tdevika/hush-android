package com.devika.hush.injection.module

import com.devika.hush.data.services.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module

class NetWorkModule{
    @Provides
    fun restrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("http://10.0.2.2:8080/")
            .build()
    }
    @Provides
    fun apiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }

}