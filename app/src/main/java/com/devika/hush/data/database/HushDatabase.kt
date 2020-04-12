package com.devika.hush.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.model.Stocks

@Database(entities = [Stocks::class, Portfolio::class], version = 8, exportSchema = false)
abstract class HushDatabase : RoomDatabase() {
    abstract fun hushDao(): HushDao
}