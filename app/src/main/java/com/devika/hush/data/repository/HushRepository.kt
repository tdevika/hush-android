package com.devika.hush.data.repository

import androidx.lifecycle.LiveData
import com.devika.hush.data.database.HushDao
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.model.Stocks
import com.devika.hush.data.services.ApiService
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import kotlin.system.measureTimeMillis

class HushRepository @Inject constructor(
    private val apiService: ApiService,
    private val hushDao: HushDao
) {

    fun getPortfolio(): LiveData<List<Portfolio>> = hushDao.getPortfolio()

    fun getStocksList(): LiveData<List<Stocks>> = hushDao.getStocks()

    suspend fun getWatchList(): List<Stocks>? = apiService.getWatchList()

    suspend fun addToWatchList(stocks: Stocks) = apiService.addToWatchList(stocks)

    suspend fun deleteWatchList(symbol: String) = apiService.deleteWatchList(symbol)

    suspend fun initDB() {
        setPortfolioToDB()
        setStocksToDB()
    }

    private suspend fun setPortfolioToDB() {
        val portfolio = apiService.getPortfolio()
        hushDao.setPortfolio(portfolio)
    }

    private suspend fun setStocksToDB() {
        val stocks = apiService.getStocks()
        hushDao.setStocks(stocks)
    }
}