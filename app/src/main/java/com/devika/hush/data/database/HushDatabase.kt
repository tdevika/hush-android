package com.devika.hush.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.model.Stock
import com.devika.hush.data.model.WatchList

@Database(
    entities = [Stock::class, Portfolio::class, WatchList::class],
    version = 1,
    exportSchema = false
)
abstract class HushDatabase : RoomDatabase() {
    abstract fun hushDao(): HushDao
}