package com.xpns.injection.module

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.xpns.XpnsApplication
import com.xpns.utils.themeswitcher.ThemeSwitcherDialogFragment
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [(NetworkModule::class)])
class AppModule {

    @Named("app")
    @Provides
    @Singleton
    fun provideAppPreferences(application: XpnsApplication): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }
    @Provides
    @Singleton
    internal fun provideThemeSwitcherDialogFragment(): ThemeSwitcherDialogFragment {
        return ThemeSwitcherDialogFragment()
    }
}