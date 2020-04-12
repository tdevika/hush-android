package com.devika.hush.injection.module

import android.icu.util.TimeUnit
import com.devika.hush.data.services.ApiService
import com.devika.hush.utilities.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module

class NetWorkModule{
    @Provides
    fun restrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

            .baseUrl(Constants.BASE_URL)
            .build()
    }
    @Provides
    fun apiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }
}