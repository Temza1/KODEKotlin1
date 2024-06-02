package presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import domain.model.WorkerState
import presentation.viewModel.MainActivityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import presentation.ui.Worker
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Composable
fun CraneHome(
    modifier: Modifier = Modifier
) {

}

@Composable
fun KodeHomeContent(viewModel : MainActivityViewModel = viewModel())
{

    val workerListInit: List<WorkerState> = emptyList()
    val suggestedWorkers by viewModel.workerListState.collectAsStateWithLifecycle(workerListInit)
    viewModel.getWorkerList()
    WorkerList(suggestedWorkers,viewModel)
}

@Composable
fun WorkerList(
    listWorkerState: List<WorkerState>,
    viewModel: MainActivityViewModel) {


    LazyColumn(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        items(listWorkerState) { listWorkerState.forEach {
            Worker(it)
        }}
    }




}

