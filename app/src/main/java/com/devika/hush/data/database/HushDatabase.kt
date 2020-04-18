package com.devika.hush.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.model.Stock
import com.devika.hush.data.model.WatchList
import com.devika.hush.utils.Constants

@Database(
    entities = [
        Stock::class,
        Portfolio::class,
        WatchList::class
    ],
    version = 1,
    exportSchema = false
)
abstract class HushDatabase : RoomDatabase() {
    abstract fun hushDao(): HushDao

    companion object {
        fun buildDatabase(context: Context): HushDatabase {
            return Room.databaseBuilder(context, HushDatabase::class.java, Constants.DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}