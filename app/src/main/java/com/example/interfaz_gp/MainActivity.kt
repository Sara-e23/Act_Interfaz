package com.example.interfaz_gp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.interfaz_gp.ui.Screen.PlayStoreScreen
import com.example.interfaz_gp.ui.theme.Interfaz_GPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Interfaz_GPTheme {
                ComposableMultiScreenApp()
            }
        }
    }
}

@Composable
fun ComposableMultiScreenApp() {
    val navController = rememberNavController()
    SetupNavGraph(navController = navController)
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Main_Menu") {

        composable("Play_Store") { PlayStoreScreen(navController) }
    }
}