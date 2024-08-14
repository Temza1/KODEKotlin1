package main.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import main.data.api.ApiService
import main.data.repository.RepositoryImpl
import main.domain.Repository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsRepositoryImpl(impl: RepositoryImpl): Repository

    @Binds
    @Singleton
    fun bindsApiServiceImpl(impl: ApiService): ApiService

}