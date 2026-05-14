package com.example.soundinch7.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.soundinch7.ui.UserViewSessionViewModel
import com.example.soundinch7.ui.component.BottomNavigationBar
import com.example.soundinch7.ui.navigation.SoundInRoutes


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    navController.navigate(route){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        } // end bottom bar
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = SoundInRoutes.LIBRARY,
            modifier = Modifier.padding(paddingValues)
        )
        {
            composable(SoundInRoutes.LIBRARY){LibraryScreen()}
            composable (SoundInRoutes.SEARCH){SearchScreen()}
            composable (SoundInRoutes.PROFILE) {
                val sessionViewModel: UserViewSessionViewModel = viewModel()
                ProfileScreen(
                    sessionViewModel = sessionViewModel,
                    onLogout = {
                        // Handle logout
                    }
                )
            }



        } // End of nav host
    } //End of scaffold



}


