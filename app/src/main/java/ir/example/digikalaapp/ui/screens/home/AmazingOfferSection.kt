package ir.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import ir.example.digikalaapp.R
import ir.example.digikalaapp.data.model.home.AmazingItem
import ir.example.digikalaapp.data.remote.NetworkResult
import ir.example.digikalaapp.ui.theme.DigikalaLightRed
import ir.example.digikalaapp.viewmodel.HomeViewModel
import java.lang.reflect.Modifier

@Composable
fun AmazingOfferSection(viewModel: HomeViewModel = hiltViewModel()) {

    var amazingItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val amazingItemResult by viewModel.amazingItems.collectAsState()

    when (amazingItemResult) {
        is NetworkResult.Success -> {
            amazingItemList = amazingItemResult.data ?: emptyList()
            loading = false
            Log.e("3636", "item : ${amazingItemList[0].name}")
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "Amazing offer section error : ${amazingItemResult.message}")
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.DigikalaLightRed)
    ) {

        LazyRow(modifier = androidx.compose.ui.Modifier.background(MaterialTheme.colors.DigikalaLightRed)) {
            item {
                AmazingOfferCard(
                    topImageResId = R.drawable.amazings,
                    bottomImageResId = R.drawable.box
                )
            }
            item {
                AmazingShowMoreItem()
            }
        }

    }
}