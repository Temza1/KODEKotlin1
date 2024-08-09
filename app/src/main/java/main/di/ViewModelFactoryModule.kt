package main.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import main.presentation.ViewModelFactory

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindsVModelFactory(impl: ViewModelFactory): ViewModelProvider.Factory
}