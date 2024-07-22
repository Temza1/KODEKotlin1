package main.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import main.domain.WorkerState
import main.presentation.ui.Worker

@Composable
fun LazyColumn(listWorkers : List<WorkerState>) {
    androidx.compose.foundation.lazy.LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = listWorkers) { worker ->
            Worker(workerState = worker)
        }
    }
}