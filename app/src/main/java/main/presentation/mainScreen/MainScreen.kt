package main.presentation.mainScreen

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import main.presentation.ViewModelFactory
import main.presentation.components.WorkerListScreen

@Composable
fun MainScreen(
    viewModel : MainScreenViewModel = viewModel(factory = ViewModelFactory(application = Application())),
    onItemClick: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    WorkerListScreen(state,onItemClick)
}