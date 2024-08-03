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
            is MainScreenContract.Event.GetSortWorkers -> onSearchTextChange(event.searchText)
        }
    }

    init {
        sendEvent(event = MainScreenContract.Event.GetWorkers)
    }

    fun getWorkerList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _workerListState.value = _workerListState.value.copy(isLoading = true)
                val workerList = getWorkerListUseCase()
                _workerListState.value =
                    _workerListState.value.copy(workers = workerList, isLoading = false)
            }
        }
    }

    fun onSearchTextChange(searchText: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (searchText.isBlank()) {
                    _workerListState.value = _workerListState.value.copy(
                        workers = _workerListState.value.workers,
                        isLoading = _workerListState.value.isLoading,
                        isSearching = _workerListState.value.isSearching,
                        searchText = _workerListState.value.searchText
                    )
                } else {
                    val sortedList = _workerListState.value.workers.filter {
                        it.doesMatchSearchQuery(searchText)
                    }
                    _workerListState.value =
                        _workerListState.value.copy(
                            workers = sortedList,
                            isLoading = false,
                            searchText = searchText
                        )
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}