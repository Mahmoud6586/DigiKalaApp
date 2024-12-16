package ir.example.digikalaapp.ui.screens.category

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

import ir.example.digikalaapp.ui.screens.home.SearchBarSection

import ir.example.digikalaapp.viewmodel.CategoryViewModel
import kotlinx.coroutines.launch

@Composable
fun CategoryScreen(navController: NavHostController) {
    Category(navController = navController)
}

@Composable
fun Category(
    navController: NavHostController,
    viewModel: CategoryViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        refreshDataFromServer(viewModel = viewModel)

    }

    swipeRefreshSection(viewModel = viewModel, navController = navController)
}

@Composable
private fun swipeRefreshSection(viewModel: CategoryViewModel, navController: NavHostController) {
    val refreshScope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)

    SwipeRefresh(state = swipeRefreshState, onRefresh = {
        refreshScope.launch {
            refreshDataFromServer(viewModel = viewModel)

            Log.e("3636", "swipeRefresh")

        }
    }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp)
        ) {

            item { SearchBarSection() }
            item { SubCategorySection() }


        }


    }
}

private suspend fun refreshDataFromServer(viewModel: CategoryViewModel) {
    viewModel.getAllDataFromServer()
}
