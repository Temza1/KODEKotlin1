package main.presentation.mainScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import main.data.repository.RepositoryImpl
import main.domain.useCases.GetWorkerListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import main.domain.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainScreenViewModel @Inject constructor(
    application: Application,
    private val getWorkersUseCase: GetWorkerListUseCase
) :
    AndroidViewModel(application),
    MainScreenContract.ViewModel {
    companion object {
        const val LOG_MA_VIEW_MODEL = "MainActivityViewModel"
    }

    private val _workerListState = MutableStateFlow(MainScreenContract.State())
    override val state: StateFlow<MainScreenContract.State> = _workerListState

//    override val repositoryImpl: Repository = RepositoryImpl()
//    override val getWorkerListUseCase = GetWorkerListUseCase(repositoryImpl)

    override fun handleEvent(event: MainScreenContract.Event) {
        when (event) {
            is MainScreenContract.Event.GetWorkers -> getWorkerList()
            is MainScreenContract.Event.GetSearchWorkers -> TODO()
            is MainScreenContract.Event.GetRadioSortWorkers -> TODO()
        }
    }

    init {
        getWorkerList()
    }

    fun getWorkerList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _workerListState.value = _workerListState.value.copy(isLoading = true)
                val workerList = getWorkersUseCase.invoke()
                _workerListState.value =
                    _workerListState.value.copy(workers = workerList, isLoading = false)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}