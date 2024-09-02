package main.presentation.mainScreen

import kotlinx.coroutines.flow.StateFlow
import main.domain.Repository
import main.domain.Worker
import main.domain.useCases.GetWorkerListUseCase

interface MainScreenContract {

    sealed class Event {
        data object GetWorkers : Event()
        data class GetSortWorkers(val searchText : String): Event()
        data class RadioSort(val isBirthSort : Boolean): Event()
    }

    data class State(
        val workers : List<Worker> = emptyList(),
        val sortedWorkers : List<Worker> = emptyList(),
        val isLoading: Boolean = false,
        val error: String? = null,
        val searchText : String = "",
        val isSearching : Boolean = false
    )

    interface ViewModel {
        val state : StateFlow<State>
        fun sendEvent(event : Event)
    }


}