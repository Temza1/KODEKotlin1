package presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import data.repositoryImpl.RepositoryImpl
import domain.model.WorkerListState
import domain.model.WorkerState
import domain.model.useCases.GetWorkerListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivityViewModel(application : Application) : AndroidViewModel(application) {

    private val repositoryImpl = RepositoryImpl(application)
    private val getWorkerListUseCase = GetWorkerListUseCase(repositoryImpl)



    private val _workerListState = MutableLiveData<List<WorkerState>>()
    val workerListState : LiveData<List<WorkerState>>
        get() = _workerListState



    private val scope = CoroutineScope(Dispatchers.IO)


    fun getWorkerList() {
        scope.launch {
            _workerListState.value = getWorkerListUseCase.invoke()
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }

}