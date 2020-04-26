package com.devika.hush.injection.module

import androidx.lifecycle.ViewModelProvider
import com.devika.hush.utils.HushViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(hushViewModelFactory: HushViewModelFactory): ViewModelProvider.Factory
}