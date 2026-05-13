package com.example.soundinch7.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.soundinch7.ui.screens.LoginScreen
import com.example.soundinch7.ui.screens.MainScreen
import com.example.soundinch7.ui.screens.RegisterScreen

@Composable
fun SoundInNavGraph (
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = SoundInRoutes.LOGIN
    ){
        composable(SoundInRoutes.LOGIN){
            LoginScreen(
                onNavigateToRegister = {
                    navController.navigate(SoundInRoutes.REGISTER)
                },
                onLoginSuccess = {
                    navController.navigate(SoundInRoutes.MAIN){
                        popUpTo(SoundInRoutes.LOGIN) { inclusive = true }
                    }
                }
            )
        }// end of login composable
        composable (SoundInRoutes.REGISTER){
            RegisterScreen(
                onNavigateToLogin = {
                    navController.navigate(SoundInRoutes.LOGIN){
                        popUpTo (SoundInRoutes.LOGIN) {inclusive = true}
                    }
                }
            )
        }// end of register compose
        composable (SoundInRoutes.MAIN){
            MainScreen()
        }// end of main composable
    }


}
@Preview(showBackground = true)
@Composable
fun SoundInNavGraphPreview() {
    val navController = rememberNavController()
    SoundInNavGraph(navController = navController)
}