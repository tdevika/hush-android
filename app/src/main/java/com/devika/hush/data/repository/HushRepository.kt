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
        val time = measureTimeMillis {
            setPortfolioToDB()
        }
        println("----Completed Portfolio in $time ms")
        val timeStocks = measureTimeMillis {
            setStocksToDB()
        }
        println("----Completed Stocks in $timeStocks ms")
    }

    private suspend fun setPortfolioToDB() {
        coroutineScope {
            val deferredPortfolio: Deferred<List<Portfolio>> =
                async(Dispatchers.IO) { apiService.getPortfolio() }
            val portfolio = deferredPortfolio.await()
            hushDao.setPortfolio(portfolio)
        }
    }

    private suspend fun setStocksToDB() {
        coroutineScope {
            val deferredStocks: Deferred<List<Stocks>> =
                async(Dispatchers.IO) { apiService.getStocks() }
            val stocks = deferredStocks.await()
            hushDao.setStocks(stocks)
        }
    }
}