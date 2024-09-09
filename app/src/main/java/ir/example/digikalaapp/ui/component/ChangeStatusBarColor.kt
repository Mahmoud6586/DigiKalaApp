package ir.example.digikalaapp.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ir.example.digikalaapp.navigation.Screen
import ir.example.digikalaapp.ui.theme.Purple200
import ir.example.digikalaapp.ui.theme.splashBg

@Composable
fun ChangeStatusBarColor(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val systemUiController = rememberSystemUiController()

    when (navBackStackEntry?.destination?.route) {
        Screen.Splash.route -> {
            //Side effect is used to ensure
            // the codes inside it would
            //run after each recomposition
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Purple200
                )
            }
        }

        else -> {
            SideEffect {

                systemUiController.setStatusBarColor(color = androidx.compose.ui.graphics.Color.White)
            }
        }
    }
}