package main.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import main.presentation.mainScreen.MainScreenViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KODEKotlin1Theme {
                val viewModel = hiltViewModel<MainScreenViewModel>()
                KodeHomeContent(viewModel)
            }
        }
    }



    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ActivityPreview() {
        KODEKotlin1Theme {
        }
    }







    companion object {
        const val LOG_MAIN_ACTIVITY = "MainActivity"
    }



}


