package presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowWorkerList()
            }
        }
    }

@Composable
fun ShowWorkerList() {
    //TODO: просим состояние у viewmodel через liveData
    Column {
        //TODO: применяем к списку forEach и передаём каждый объект списка в метод card
    }
}

