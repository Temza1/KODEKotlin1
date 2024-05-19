package domain.model.useCases

import domain.model.Repository
import domain.model.WorkerListState
import domain.model.WorkerState

class GetWorkerListUseCase(private val repository: Repository) {

    suspend operator fun invoke() : List<WorkerState> {
        return repository.getWorkerList()
    }

}