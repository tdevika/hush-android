package com.devika.hush.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.model.Stocks

@Dao
interface HushDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setPortfolio(stocks: List<Portfolio>)

    @Query("SELECT * FROM portfolio ")
    fun getPortfolio(): LiveData<List<Portfolio>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setStocks(stocks: List<Stocks>)

    @Query("SELECT * FROM stocks ")
    fun getStocks(): LiveData<List<Stocks>>
}