package presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import domain.model.WorkerListState
import domain.model.WorkerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import presentation.ui.card
import presentation.viewModel.MainActivityViewModel


class MainActivity : ComponentActivity() {

    private lateinit var viewModel : MainActivityViewModel
    private lateinit var workerListState: List<WorkerState>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.getWorkerList()

        viewModel.workerListState.observe(this, Observer {
            workerListState = it
        })

        setContent() {
            ShowWorkerList(workerListState)
        }


       /* viewModel.getWorkerList()


        viewModel.workerListState.observe(this, Observer {
            workerListState = it
        })

        setContent() {
            if (this::workerListState.isInitialized) {
                ShowWorkerList(workerListState)
            } else {
                Log.d(LOG_MAIN_ACTIVITY,"ошибка lateinit")
            }
        }*/


    }
    companion object {
        const val LOG_MAIN_ACTIVITY = "MainActivity"
    }

        /*// Update the uiState
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {

            }
        }*/

    }

@Composable
fun ShowWorkerList(workerListState : List<WorkerState>) {

    Column {
        workerListState.forEach{
            card(it)
        }
    }
}

