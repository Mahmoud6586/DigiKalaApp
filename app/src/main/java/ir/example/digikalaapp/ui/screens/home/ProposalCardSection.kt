package ir.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import ir.example.digikalaapp.data.model.home.Slider
import ir.example.digikalaapp.data.remote.NetworkResult
import ir.example.digikalaapp.viewmodel.HomeViewModel

@Composable
fun ProposalCardSection(
    viewModel: HomeViewModel = hiltViewModel()
) {

    var bannersList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }


    val bannersResult by viewModel.banners.collectAsState()

    when (bannersResult) {
        is NetworkResult.Success -> {
            loading = false
            bannersList = bannersResult.data ?: emptyList()
        }

        is NetworkResult.Loading -> {
            loading = true
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "Banners section error: ${bannersResult.message}")
        }
    }
}