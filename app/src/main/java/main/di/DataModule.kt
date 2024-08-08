package main.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import main.data.api.ApiService
import main.data.repository.RepositoryImpl
import main.domain.Repository

@Module
interface DataModule {

    @Binds
    fun bindsRepositoryImpl(impl: RepositoryImpl): Repository

    @Binds
    fun bindsApiServiceImpl(impl : ApiService) : ApiService

}