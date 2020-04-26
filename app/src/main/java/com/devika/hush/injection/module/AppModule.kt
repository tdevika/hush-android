package com.devika.hush.injection.module

import android.content.Context
import com.devika.hush.HushApplication
import com.devika.hush.data.database.HushDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun providesContext(application: HushApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun providesHushDatabase(context: Context) = HushDatabase.buildDatabase(context)

    @Provides
    @Singleton
    fun providesHushDao(hushDatabase: HushDatabase) = hushDatabase.hushDao()
}