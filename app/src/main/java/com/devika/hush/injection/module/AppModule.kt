package com.devika.hush.injection.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.devika.hush.HushApplication
import com.devika.hush.data.database.HushDao
import com.devika.hush.data.database.HushDatabase
import com.devika.hush.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModuleBinds::class])
class AppModule {


    @Provides
    @Singleton
    fun provideDatabaseInstance(application: Application): HushDatabase {
        return Room.databaseBuilder(
            application,
            HushDatabase::class.java,
            Constants.DB
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideDao(hushDatabase: HushDatabase): HushDao {
        return hushDatabase.hushDao()
    }
}

@Module
abstract class AppModuleBinds {
    @Binds
    abstract fun provideApplication(application: HushApplication): Context
}