package main.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.kodekotlin1.ui.theme.KODEKotlin1Theme
import main.app.App
import main.presentation.navigation.Navigation
import javax.inject.Inject


class MainActivity : ComponentActivity() {

    @Inject lateinit var factory: ViewModelProvider.Factory

    private val component by lazy {
        (application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        component.inject

        setContent {
            KODEKotlin1Theme {
                Navigation(getVmFactory = {factory})
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


