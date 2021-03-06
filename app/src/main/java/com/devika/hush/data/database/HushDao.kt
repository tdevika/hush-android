package com.devika.hush.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.devika.hush.data.model.DetailWatchList
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.model.Stock
import com.devika.hush.data.model.WatchList

@Dao
interface HushDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setPortfolio(stocks: List<Portfolio>)

    @Query("SELECT * FROM portfolio")
    suspend fun getPortfolio(): List<Portfolio>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setStocks(stocks: List<Stock>)

    @Query("SELECT * FROM stock")
    suspend fun getStocks(): List<Stock>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setWatchList(stocks: List<WatchList>)

    @Transaction
    @Query("SELECT * FROM watchlist")
    suspend fun getWatchList(): List<DetailWatchList>
}
