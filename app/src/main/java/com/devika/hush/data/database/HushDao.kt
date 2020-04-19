package com.devika.hush.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.devika.hush.data.model.DetailWatchList
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.model.Stock
import com.devika.hush.data.model.WatchList

@Dao
interface HushDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setPortfolio(stocks: List<Portfolio>)

    @Query("SELECT * FROM portfolio")
    fun getPortfolio(): LiveData<List<Portfolio>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setStocks(stocks: List<Stock>)

    @Query("SELECT * FROM stock")
    fun getStocks(): LiveData<List<Stock>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setWatchList(stocks: List<WatchList>)

    @Transaction
    @Query("SELECT * FROM watchlist")
    fun getWatchList(): LiveData<List<DetailWatchList>>
}