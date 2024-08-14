package main.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import main.domain.Worker
import main.presentation.KodeHomeContent
import main.presentation.mainScreen.MainScreen
import main.presentation.mainScreen.MainScreenViewModel

@Composable
fun Navigation() {


    val navController = rememberNavController()
    val startDestination = "Home"

    NavHost(navController = navController, startDestination = startDestination) {
        composable("Home") {
            KodeHomeContent()
        }

    }
}

