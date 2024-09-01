package ir.example.digikalaapp.ui.screens

import android.window.SplashScreen
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun SplashScreen(navController: NavHostController){
    Text(text = "Splash screen")
}