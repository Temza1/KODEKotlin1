package main.presentation

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import main.domain.WorkerState
import main.presentation.viewModel.MainActivityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import kotlinx.coroutines.delay
import main.presentation.ui.ProfileScreen
import main.presentation.ui.WorkerListScreen
import main.presentation.viewModel.ViewModelFactory


@Composable
fun KodeHomeContent(
    modifier : Modifier = Modifier
)
{

    Scaffold(
        content = {
            padding ->
            Column(
                modifier= modifier.padding(padding)
            ) {
                ScreenContent()
            }
        }
    )

    var IsShowProfileScreen by remember {mutableStateOf(true)}

}


@Composable
fun ScreenContent(
    viewModel : MainActivityViewModel = viewModel(factory = ViewModelFactory(application = Application()))
) {

    val suggestedWorkers by viewModel.workerListState.collectAsState()
    val mockListWorkers : ArrayList<WorkerState> by remember { mutableStateOf(getMockWorkers()) }

    var profileScreenIsShow by remember {mutableStateOf(true)}

    WorkerListScreen(suggestedWorkers)

}

private fun getMockWorkers(): ArrayList<WorkerState> {

    val listWorkers = ArrayList<WorkerState>()
    for(i in 0..20) {
        val workerState = WorkerState(
            "456$i",
            "https://cerenas.club/uploads/posts/2022-12/1671182249_cerenas-club-p-kot-v-chernikh-ochkakh-instagram-48.jpg",
            "Артём$i",
            "Затеев$i",
            "dp$i",
            "developer$i",
            "dp$i",
            "октябрь$i",
            "$i"
        )

        listWorkers.add(workerState)
    }
    return listWorkers
}


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




