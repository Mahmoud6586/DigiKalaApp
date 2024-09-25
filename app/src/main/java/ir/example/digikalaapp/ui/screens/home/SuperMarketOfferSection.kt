package ir.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import ir.example.digikalaapp.ui.theme.DigikalaLightGreen
import ir.example.digikalaapp.ui.theme.DigikalaLightRed
import ir.example.digikalaapp.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun SuperMarketOfferSection(
    viewModel: HomeViewModel = hiltViewModel()
) {

    var superMarketItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }


    val superMarketItemResult by viewModel.superMarketItems.collectAsState()
    when (superMarketItemResult) {
        is NetworkResult.Success -> {
            superMarketItemList = superMarketItemResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Loading -> {
            loading = true
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "SuperMarketAmazingSection error: ${superMarketItemResult.message}")
        }
    }

    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.DigikalaLightRed)
    ) {

        LazyRow(modifier = androidx.compose.ui.Modifier.background(MaterialTheme.colors.DigikalaLightGreen)) {
            item {
                AmazingOfferCard(
                    topImageResId = R.drawable.supermarketamazings,
                    bottomImageResId = R.drawable.fresh
                )
            }

            items(superMarketItemList) { item ->
                AmazingItem(item = item)
            }
            item {
                AmazingShowMoreItem()
            }
        }

    }

}