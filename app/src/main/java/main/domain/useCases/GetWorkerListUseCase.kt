package main.domain.useCases

import kotlinx.coroutines.flow.Flow
import main.data.repository.RepositoryImpl
import main.domain.Repository
import main.domain.Worker
import javax.inject.Inject

class GetWorkerListUseCase @Inject constructor(private val repository: RepositoryImpl) {

    suspend operator fun invoke(): List<Worker> {
        return repository.getWorkerList()
    }

}