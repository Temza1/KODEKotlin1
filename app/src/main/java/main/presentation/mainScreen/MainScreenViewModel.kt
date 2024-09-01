package main.presentation.mainScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import main.data.repository.RepositoryImpl
import main.domain.useCases.GetWorkerListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import main.domain.Repository
import main.domain.Worker

class MainScreenViewModel(application: Application) : AndroidViewModel(application),
    MainScreenContract.ViewModel {
    companion object {
        const val LOG_MA_VIEW_MODEL = "MainActivityViewModel"
    }

    private val _workerListState = MutableStateFlow(MainScreenContract.State())
    override val state: StateFlow<MainScreenContract.State> = _workerListState

    override val repositoryImpl: Repository = RepositoryImpl(application)
    override val getWorkerListUseCase = GetWorkerListUseCase(repositoryImpl)

    override fun sendEvent(event: MainScreenContract.Event) {
        when (event) {
            is MainScreenContract.Event.GetWorkers -> getWorkerList()
            is MainScreenContract.Event.GetSortWorkers -> getSortWorkers(event.searchText)
            is MainScreenContract.Event.RadioSort -> radioSort(event.isBirthSort)
        }
    }

    init {
        sendEvent(event = MainScreenContract.Event.GetWorkers)
    }

    private fun getWorkerList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _workerListState.value = _workerListState.value.copy(
                    isLoading = true
                )
                val workerList = getWorkerListUseCase().sortedBy {it.firstName}
                _workerListState.value = _workerListState.value.copy(
                    workers = workerList,
                    sortedWorkers = workerList,
                    isLoading = false
                )

            }
        }
    }

    private fun getSortWorkers(searchText: String) {
        if (searchText.isBlank()) {
            _workerListState.update { it.copy(
                sortedWorkers = _workerListState.value.workers,
                searchText = ""
            ) }
        } else {
            _workerListState.update { it.copy(searchText = searchText) }
            val sortedList = ArrayList<Worker>()
            _workerListState.value.workers.forEach {
                if(it.doesMatchSearchQuery(searchText)) {
                    sortedList.add(it)
                }
            }
            _workerListState.update { it.copy(sortedWorkers = sortedList) }
        }
    }

    private fun radioSort(isBirthSort : Boolean) {
        if(_workerListState.value.workers.isNotEmpty()) {
            if (isBirthSort) {
                val sortedBirthWorkers = _workerListState.value.workers.sortedBy {it.birthday}
                _workerListState.update { it.copy(sortedWorkers = sortedBirthWorkers) }
            } else {
                val sortedAlphaWorkers = _workerListState.value.workers.sortedBy {it.firstName}
                _workerListState.update { it.copy(sortedWorkers = sortedAlphaWorkers) }
            }
        }
    }




    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}