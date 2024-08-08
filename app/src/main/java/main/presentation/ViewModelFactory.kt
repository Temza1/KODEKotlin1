package main.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import main.domain.useCases.GetWorkerListUseCase
import main.presentation.mainScreen.MainScreenViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val viewModels : @JvmSuppressWildcards Map<String,ViewModel>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModels[modelClass.simpleName] as T
    }
}