package com.devika.hush.data.repository

import com.devika.hush.data.database.HushDao
import com.devika.hush.data.model.DetailWatchList
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.model.Stock
import com.devika.hush.data.model.WatchList
import com.devika.hush.data.services.ApiService
import javax.inject.Inject

class HushRepository @Inject constructor(
    private val apiService: ApiService,
    private val hushDao: HushDao
) {

    suspend fun getPortfolio(): List<Portfolio> = hushDao.getPortfolio()

    suspend fun getStocks(): List<Stock> = hushDao.getStocks()

    suspend fun getWatchList(): List<DetailWatchList> = hushDao.getWatchList()

    suspend fun addToWatchList(watchList: WatchList) {
        apiService.addToWatchList(watchList)
    }

    suspend fun deleteWatchList(symbol: String) {
        apiService.deleteWatchList(symbol)
    }

    suspend fun refreshCacheWithRemoteData() {
        refreshCacheWithRemoteStocks()
        refreshCacheWithRemotePortfolio()
        refreshCacheWithRemoteWatchList()
    }

    private suspend fun refreshCacheWithRemoteWatchList() {
        val watchList = apiService.getWatchList()
        hushDao.setWatchList(watchList)
    }

    private suspend fun refreshCacheWithRemotePortfolio() {
        val portfolio = apiService.getPortfolio()
        hushDao.setPortfolio(portfolio)
    }

    private suspend fun refreshCacheWithRemoteStocks() {
        val stocks = apiService.getStocks()
        hushDao.setStocks(stocks)
    }
}
