package main.di

import android.app.Application
import android.content.Context
import dagger.Module
import main.data.repository.RepositoryImpl
import main.domain.Repository

@Module
class DataModule {

    fun provideRepositoryImpl() : Repository {
        return RepositoryImpl()
    }
}