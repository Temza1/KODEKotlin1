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
                KodeHomeContent()
            }
        }
    }




    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun ActivityPreview() {
        KODEKotlin1Theme {
            KodeHomeContent()
        }
    }







    companion object {
        const val LOG_MAIN_ACTIVITY = "MainActivity"
    }



}


