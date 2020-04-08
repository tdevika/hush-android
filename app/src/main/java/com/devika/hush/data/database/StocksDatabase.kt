package com.devika.hush.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devika.hush.data.model.Stocks

@Database(entities = [Stocks::class], version = 5, exportSchema = false)
abstract class StocksDatabase : RoomDatabase() {
    abstract fun stocksDao(): StocksDao

    companion object {
        @Volatile
        private var INSTANCE: StocksDatabase? = null

        fun getInstance(context: Context): StocksDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StocksDatabase::class.java,
                        "stock_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}