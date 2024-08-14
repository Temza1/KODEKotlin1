package main.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import dagger.hilt.android.AndroidEntryPoint
import main.app.App
import main.presentation.mainScreen.MainScreenViewModel
import main.presentation.navigation.Navigation
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

   val vm : MainScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            KODEKotlin1Theme {
                Navigation()
            }
        }
    }


//    @Preview(showBackground = true, showSystemUi = true)
//    @Composable
//    fun ActivityPreview() {
//        KODEKotlin1Theme {
//            Navigation()
//        }
//    }


    companion object {
        const val LOG_MAIN_ACTIVITY = "MainActivity"
    }


}


