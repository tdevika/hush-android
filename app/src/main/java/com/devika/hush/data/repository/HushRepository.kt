package com.devika.hush.data.repository

import android.app.Application
import android.content.Context
import com.devika.hush.HushApplication
import com.devika.hush.data.database.StocksDatabase
import com.devika.hush.data.model.Stocks
import com.devika.hush.data.services.ApiService
import javax.inject.Inject

class HushRepository @Inject constructor(
    private val apiService: ApiService,
      val application: Context
) {
    var stocksDao = StocksDatabase.getInstance(application).stocksDao()
    suspend fun getPortfolio(): List<Stocks> {
        val stocks: List<Stocks> = apiService.getPortfolioList()
        stocksDao.setStocks(stocks)
        return stocksDao.getStocks()
    }

    suspend fun getAllStocksList(): List<Stocks> {
        return apiService.getAllStocksList()
    }

    suspend fun getWatchList(): List<Stocks>? {
        return apiService.getWatchList()
    }

    suspend fun addToWatchList(stocks: Stocks) {
        apiService.addToWatchList(stocks)
    }

    suspend fun deleteWatchList(stocks: Stocks) {
        apiService.deleteWatchList(stocks)
    }
}