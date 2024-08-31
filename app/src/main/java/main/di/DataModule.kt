package main.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import main.data.api.ApiService
import main.data.mapper.WorkerMapper
import main.data.repository.RepositoryImpl
import main.domain.Repository
import main.domain.useCases.GetWorkerListUseCase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideGetWorkerListUseCase(repImpl : RepositoryImpl) : GetWorkerListUseCase {
        return GetWorkerListUseCase(repImpl)
    }

    @Provides
    fun provideRepositoryImpl(apiService: ApiService, mapper: WorkerMapper): RepositoryImpl {
        return RepositoryImpl(apiService,mapper)
    }

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit.Builder,
        okHttpClient: OkHttpClient
    ) : ApiService {
        return retrofit.baseUrl("https://stoplight.io/mocks/kode-education/trainee-test/25143926/")
            .client(okHttpClient.newBuilder().build())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideMapper(): WorkerMapper {
        return WorkerMapper()
    }

}