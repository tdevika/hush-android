package com.hush.injection.module

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.hush.HushApplication
import com.hush.utils.themeswitcher.ThemeSwitcherDialogFragment
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [(NetworkModule::class)])
class AppModule {

    @Named("app")
    @Provides
    @Singleton
    fun provideAppPreferences(application: HushApplication): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    internal fun provideThemeSwitcherDialogFragment(): ThemeSwitcherDialogFragment {
        return ThemeSwitcherDialogFragment()
    }
}