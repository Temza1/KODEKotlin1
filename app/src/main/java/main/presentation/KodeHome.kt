package main.presentation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import main.domain.Worker
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import coil.compose.AsyncImage
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import kotlinx.coroutines.delay
import main.presentation.components.ProfileScreen
import main.presentation.mainScreen.MainScreen
import main.presentation.mainScreen.MainScreenViewModel


@Composable
fun KodeHomeContent(viewModel: MainScreenViewModel) {
    var showProfileScreen by remember { mutableStateOf(false) }
    var worker by remember { mutableStateOf(getWorker()) }

    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier.padding(padding)
            ) {
                if (showProfileScreen) {
                    ProfileScreen(
                        modifier = Modifier,
                        onClickReturnButton = { showProfileScreen = false },
                        worker
                    )
                } else {
                    MainScreen(
                        modifier = Modifier,
                        viewModel,
                        getProfileInfo = {
                            worker = it
                            showProfileScreen = true
                        }
                    )
                }
            }
        }
    )
}

@Composable
private fun Toast(context: Context, text: String) {
    android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_LONG).show()
}

private fun getMockWorkers(): ArrayList<Worker> {

    val listWorkers = ArrayList<Worker>()
    for (i in 0..20) {
        val worker = Worker(
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

        listWorkers.add(worker)
    }
    return listWorkers
}

private fun getWorker(): Worker {
    return Worker(
        "456",
        "https://cerenas.club/uploads/posts/2022-12/1671182249_cerenas-club-p-kot-v-chernikh-ochkakh-instagram-48.jpg",
        "Артём",
        "Затеев",
        "dp",
        "developer",
        "dp",
        "октябрь",
        ""
    )
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun KodeHomePreview() {
//    KODEKotlin1Theme {
//        KodeHomeContent()
//    }
//}


const val splashWaitTime: Long = 5000

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
        AsyncImage(
            model = androidx.core.R.drawable.notification_action_background,
            contentDescription = null
        )
    }
}




