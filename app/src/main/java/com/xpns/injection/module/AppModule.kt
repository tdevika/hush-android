package com.xpns.injection.module

import com.xpns.ui.themeswitcher.ThemeSwitcherDialogFragment
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [(NetworkModule::class)])
class AppModule {

    @Provides
    @Singleton
    internal fun provideThemeSwitcherDialogFragment(): ThemeSwitcherDialogFragment {
        return ThemeSwitcherDialogFragment()
    }
}