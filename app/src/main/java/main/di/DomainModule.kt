package main.di

import dagger.Module
import main.data.repositoryImpl.RepositoryImpl
import main.domain.Repository
import main.domain.useCases.GetWorkerListUseCase

@Module
class DomainModule {

    fun provideGetWorkerListUseCase(repository: Repository) : GetWorkerListUseCase {
        return GetWorkerListUseCase(repository = repository)
    }

}