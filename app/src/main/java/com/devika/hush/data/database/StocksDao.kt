package com.devika.hush.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devika.hush.data.model.Stocks

@Dao
interface StocksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setStocks(stocks: List<Stocks>)

    @Query("SELECT * FROM stocks ")
    suspend fun getStocks():List<Stocks>

}