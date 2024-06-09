package main.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KODEKotlin1Theme {
                WorkerScreen()
            }
        }

    }

    @Composable
    fun WorkerScreen() {
        KodeHome()
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        KODEKotlin1Theme {
            WorkerScreen()
        }
    }



    companion object {
        const val LOG_MAIN_ACTIVITY = "MainActivity"
    }



}


