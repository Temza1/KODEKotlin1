package presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import domain.model.WorkerState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import presentation.ui.Worker
import presentation.viewModel.MainActivityViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.getWorkerList()

        viewModel.workerListState.observe(this, Observer {
            workerListState = it
        })*/
//        var workerList : List<WorkerState> by mutableStateOf(emptyList())
//
//        lifecycleScope.launch {
//            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                launch { viewModel.workerListState
//                    .onEach { workerList = it } }
//            }
//        }


        setContent {
            WorkerScreen()
        }


//WorkersScreen (содержит ViewModel): WorkersContent, WorkersLoading, WorkersError
    }

    @Composable
    fun WorkerScreen() {

        KodeHomeContent()

//        if (workerList.isNotEmpty()) {
//            KodeHomeContent(workerList)
//        } else {
//            ///анимация загрузки
//        }

    }

    companion object {
        const val LOG_MAIN_ACTIVITY = "MainActivity"
    }



}


