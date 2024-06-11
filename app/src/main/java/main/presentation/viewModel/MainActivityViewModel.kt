package main.presentation.viewModel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import main.data.repositoryImpl.RepositoryImpl
import main.domain.WorkerState
import main.domain.useCases.GetWorkerListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(application : Application) : AndroidViewModel(application) {

    companion object {
        const val LOG_MA_VIEW_MODEL = "MainActivityViewModel"
    }

    private val repositoryImpl = RepositoryImpl(application)
    private val getWorkerListUseCase = GetWorkerListUseCase(repositoryImpl)



    private val _workerListState = MutableStateFlow<List<WorkerState>>(emptyList())
    val workerListState : StateFlow<List<WorkerState>> = _workerListState.asStateFlow()




    fun getWorkerList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
//                val workerListFromRep = getWorkerListUseCase.invoke()
                val workerListMoc = getListMoc()
                _workerListState.value = workerListMoc
            }
        }
    }

    fun getListMoc() : List<WorkerState> {


        val listWorkers : List<WorkerState> = listOf()

        for(i in 0..100) {

            val workerState = WorkerState(
                "456$i",
                "https://cdn.fakercloud.com/avatars/marrimo_128.jpg",
                "Артём$i",
                "Затеев$i",
                "dp$i",
                "developer$i",
                "dp$i",
                "октябрь$i",
                "$i"
            )

            listWorkers.plus(workerState)
        }

        return listWorkers
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}