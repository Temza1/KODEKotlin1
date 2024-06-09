package main.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import main.domain.WorkerState
import main.presentation.viewModel.MainActivityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import main.presentation.ui.Worker
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import kotlinx.coroutines.delay




@Composable
fun KodeHomeContent(
    viewModel : MainActivityViewModel = viewModel())
{
    var showLandingScreen by remember {mutableStateOf(true)}
    val suggestedWorkers by viewModel.workerListState.collectAsStateWithLifecycle()

    viewModel.getListMoc()


    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = suggestedWorkers) { worker ->
            Worker(workerState = worker)
        }
    }
}

//@Composable
//fun WorkerList(
//    listWorkerState: List<WorkerState>,
//    modifier: Modifier = Modifier) {
//
//    LazyColumn(
//        modifier = modifier
//            .fillMaxSize()
//    ) {
//        items(listWorkerState) { listWorkerState.forEach {
//            Worker(it)
//        }}
//    }
//
//}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun KodeHome() {
    KodeHomeContent()
}
















const val splashWaitTime : Long = 5000
@Composable
fun LandingScreen(onTimeout: () -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        // TODO Codelab: LaunchedEffect and rememberUpdatedState step
        // TODO: Make LandingScreen disappear after loading data

        val currentOnTimeOut by rememberUpdatedState(onTimeout)

        LaunchedEffect(Unit) {
            delay(splashWaitTime)
            currentOnTimeOut()
        }
        AsyncImage(model = androidx.core.R.drawable.notification_action_background, contentDescription = null)
    }
}




