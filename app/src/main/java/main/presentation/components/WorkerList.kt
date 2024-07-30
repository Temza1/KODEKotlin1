@file:OptIn(ExperimentalFoundationApi::class)

package main.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import main.domain.Worker
import main.presentation.KodeHomeContent

@Composable
fun WorkerList(
    modifier: Modifier = Modifier,
    getProfileInfo: (Worker) -> Unit,
    workersItem : List<Worker>
) {

    androidx.compose.foundation.lazy.LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = workersItem) { worker ->
            Worker(getProfileInfo,worker = worker)
        }
    }

}





private fun getMockWorkers(): ArrayList<Worker> {

    val listWorkers = ArrayList<Worker>()
    for(i in 0..20) {
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WorkerListScreenPreview() {
    KODEKotlin1Theme {
        KodeHomeContent()
    }
}
