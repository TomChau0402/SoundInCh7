package com.example.soundinch7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.soundinch7.ui.navigation.SoundInNavGraph
import com.example.soundinch7.ui.screens.LoginScreen
import com.example.soundinch7.ui.theme.SoundInCh7Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoundInCh7Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   val navController = rememberNavController()
                    SoundInNavGraph(navController = navController)
                }
            }
        }
    }
}


@Preview (showBackground = true)
@Composable
fun SoundInPreview() {
    SoundInCh7Theme() {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ){
            LoginScreen ( onNavigateToRegister = {},
                onLoginSuccess = {})
        } // end of surface
        }
    }

