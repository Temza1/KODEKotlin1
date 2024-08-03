package main.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import main.domain.useCases.GetWorkerListUseCase
import main.presentation.mainScreen.MainScreenViewModel

class ViewModelFactory(
    private val application: Application,
    private val getWorkersUseCase : GetWorkerListUseCase
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainScreenViewModel(application,getWorkersUseCase) as T
    }
}