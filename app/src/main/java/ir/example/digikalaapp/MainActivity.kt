package ir.example.digikalaapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.example.digikalaapp.navigation.BottomNavigationBar
import ir.example.digikalaapp.navigation.SetupNavGraph
import ir.example.digikalaapp.ui.component.AppConfig
import ir.example.digikalaapp.ui.component.ChangeStatusBarColor
import ir.example.digikalaapp.ui.theme.DigiKalaAppTheme
import ir.example.digikalaapp.util.Constants.ENGLISH_LANG
import ir.example.digikalaapp.util.Constants.PERSIAN_LANG
import ir.example.digikalaapp.util.Constants.USER_LANGUAGE
import ir.example.digikalaapp.util.LocaleUtils

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            DigiKalaAppTheme {

                navController = rememberNavController()
                ChangeStatusBarColor(navController)
                AppConfig()

                Log.e("3636", USER_LANGUAGE)

                val direction = if (USER_LANGUAGE == ENGLISH_LANG) {
                    LayoutDirection.Ltr

                } else {
                    LayoutDirection.Rtl
                }
                LocaleUtils.setLocale(LocalContext.current, USER_LANGUAGE)

                //This lets us change direction on scaffold
                CompositionLocalProvider(value = LocalLayoutDirection provides direction) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                })
                        }
                    ) {
                        SetupNavGraph(navController = navController)
                    }
                }


            }
        }
    }
}

