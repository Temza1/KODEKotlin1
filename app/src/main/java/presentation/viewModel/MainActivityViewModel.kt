package presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import data.repositoryImpl.RepositoryImpl
import domain.model.WorkerListState
import domain.model.WorkerState
import domain.model.useCases.GetWorkerListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(application : Application) : AndroidViewModel(application) {

    private val repositoryImpl = RepositoryImpl(application)
    private val getWorkerListUseCase = GetWorkerListUseCase(repositoryImpl)



    private val _workerListState = MutableStateFlow<List<WorkerState>>(emptyList())
    val workerListState : SharedFlow<List<WorkerState>> = _workerListState.asStateFlow()

    init {
        _workerListState.value = emptyList()
    }





    fun getWorkerList() {
        viewModelScope.launch {
            val workerListFromRep = withContext(Dispatchers.IO) {
                getWorkerListUseCase.invoke()
            }
            _workerListState.value = workerListFromRep
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}