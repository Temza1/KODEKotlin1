package presentation

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.checkScrollableContainerConstraints
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import domain.model.WorkerState
import kotlinx.coroutines.flow.MutableStateFlow
import presentation.viewModel.MainActivityViewModel
import presentation.viewModel.ViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import presentation.ui.Worker
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color


@Composable
fun KodeHomeContent(viewModel : MainActivityViewModel = viewModel())
{
    val workerListInit: List<WorkerState> = emptyList()
    val suggestedWorkers by viewModel.workerListState.collectAsStateWithLifecycle(workerListInit)
    WorkerList(suggestedWorkers,viewModel)
}

@Composable
fun WorkerList(
    workerState: List<WorkerState>,
    viewModel: MainActivityViewModel) {


    LazyColumn(
        modifier = Modifier.background(Color.Black).fillMaxSize().clickable {
            //обновление списка по клику
            viewModel.getWorkerList()
        }
    ) {
        items(workerState) { workerState.forEach {
            Worker(it)
        }}
    }




}

