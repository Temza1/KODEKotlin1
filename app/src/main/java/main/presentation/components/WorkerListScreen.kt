package main.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import main.domain.WorkerState
import main.presentation.KodeHomeContent
import main.presentation.mainScreen.MainScreenContract

@Composable
fun WorkerListScreen(
    state : MainScreenContract.State,
    onItemClick: () -> Unit
) {
    LazyColumn(state.workers,onItemClick)
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
fun WorkerListScreenPreview() {
    KODEKotlin1Theme {
        KodeHomeContent()
    }
}
