package main.domain.useCases

import main.domain.Repository
import main.domain.WorkerState

class GetWorkerListUseCase(private val repository: Repository) {

    suspend operator fun invoke() : List<WorkerState> {
        return repository.getWorkerList()
    }

}