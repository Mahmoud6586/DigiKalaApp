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
import ir.example.digikalaapp.ui.component.CenterBannerItem
import ir.example.digikalaapp.viewmodel.HomeViewModel

@Composable
fun CenterBannerSection(bannerNumber: Int, viewModel: HomeViewModel = hiltViewModel()) {

    var centerBannerList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val centerBannerResult by viewModel.centerBanners.collectAsState()

    when (centerBannerResult) {
        is NetworkResult.Success -> {
            centerBannerList = centerBannerResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            Log.e("3636", "CenterBanner section error : ${centerBannerResult.message}")
            loading = false
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    if (centerBannerList.isNotEmpty()) {
        CenterBannerItem(imgUrl = centerBannerList[bannerNumber - 1].image)
    }


}