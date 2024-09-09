package ir.example.digikalaapp.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.example.digikalaapp.MainActivity
import ir.example.digikalaapp.util.Constants.ENGLISH_LANG
import ir.example.digikalaapp.util.Constants.PERSIAN_LANG
import ir.example.digikalaapp.viewmodel.DataStoreViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    dataStore: DataStoreViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val activity = LocalContext.current as Activity

        Text(text = "Profile Screen")
        Button(onClick = {
            dataStore.saveUserLanguage(PERSIAN_LANG)
            activity.apply {

                finish()
                //Goes from the current activity to the MainActivity
                startActivity(Intent(activity, MainActivity::class.java))
            }
        }) {
            Text(text = "FA")
        }

        Button(onClick = {

            dataStore.saveUserLanguage(ENGLISH_LANG)
            activity.apply {

                finish()
                //Goes from the current activity to the MainActivity
                startActivity(Intent(activity, MainActivity::class.java))
            }
        }) {
            Text(text = "ENG")
        }
    }
}