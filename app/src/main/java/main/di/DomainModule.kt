package main.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import main.data.mapper.WorkerMapper
import main.data.repository.RepositoryImpl
import main.domain.Repository
import main.domain.useCases.GetWorkerListUseCase

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetWorkerListUseCase(repository: RepositoryImpl) : GetWorkerListUseCase {
        return GetWorkerListUseCase(repository = repository)
    }

    @Provides
    fun provideMapper(): WorkerMapper {
        return WorkerMapper()
    }

}