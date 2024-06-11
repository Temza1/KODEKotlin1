package main.presentation

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.lifecycle.ViewModelProvider
import coil.compose.AsyncImage
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import kotlinx.coroutines.delay
import main.presentation.viewModel.ViewModelFactory


@Composable
fun KodeHomeContent(
    viewModel : MainActivityViewModel = viewModel(factory = ViewModelFactory(application = Application()))
)
{
//    viewModel.getWorkerList()
//    val suggestedWorkers by viewModel.workerListState.collectAsStateWithLifecycle()
//    var showLandingScreen by remember {mutableStateOf(true)}



    val listWorkers : List<WorkerState> by remember { mutableStateOf(listOf())}

    for(i in 0..20) {

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

    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = listWorkers) { worker ->
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KodeHomePreview() {
    KODEKotlin1Theme {
        KodeHomeContent()
    }
}













const val splashWaitTime : Long = 5000
@SuppressLint("PrivateResource")
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




