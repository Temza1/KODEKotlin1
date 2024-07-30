package main.presentation.mainScreen

import kotlinx.coroutines.flow.StateFlow
import main.domain.Repository
import main.domain.Worker
import main.domain.useCases.GetWorkerListUseCase

interface MainScreenContract {

    sealed class Event {
        object GetWorkers : Event()
        data class GetSearchWorkers(val searchString : String) : Event()
        data class GetRadioSortWorkers(val isBirthdaySort : Boolean) : Event()
    }

    data class State(
        val workers : List<Worker> = emptyList(),
        val isLoading: Boolean = false,
        val error: String? = null
    )

    interface ViewModel {
        val state : StateFlow<State>
        val repositoryImpl : Repository
        val getWorkerListUseCase : GetWorkerListUseCase
        fun handleEvent(event : Event)
    }


}