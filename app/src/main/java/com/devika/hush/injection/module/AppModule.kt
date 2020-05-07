package com.devika.hush.injection.module

import android.content.Context
import com.devika.hush.HushApplication
import com.devika.hush.data.database.HushDatabase
import com.devika.hush.data.repository.PreferenceRepository.Companion.PREFS_NAME
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

    @Provides
    @Singleton
    fun providesSharedPreferences(context: Context) = context.getSharedPreferences(
        PREFS_NAME,
        Context.MODE_PRIVATE
    )
}
