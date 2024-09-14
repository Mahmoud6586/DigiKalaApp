package ir.example.digikalaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.example.digikalaapp.ui.screens.BasketScreen
import ir.example.digikalaapp.ui.screens.CategoryScreen
import ir.example.digikalaapp.ui.screens.home.HomeScreen
import ir.example.digikalaapp.ui.screens.ProfileScreen
import ir.example.digikalaapp.ui.screens.SplashScreen


@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Category.route) {
            CategoryScreen(navController = navController)
        }

        composable(route = Screen.Basket.route) {
            BasketScreen(navController = navController)
        }



        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }

    }
}