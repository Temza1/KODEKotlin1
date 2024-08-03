package main.di

import android.app.Application
import android.content.Context
import dagger.Module
import main.domain.useCases.GetWorkerListUseCase
import main.presentation.ViewModelFactory

@Module
class AppModule(private val context : Context) {

    fun provideContext() : Context {
        return context
    }

    fun provideViewModelFactory(
        application: Application,
        getWorkersUseCase: GetWorkerListUseCase
    ): ViewModelFactory {
        return ViewModelFactory(application,getWorkersUseCase)
    }
}