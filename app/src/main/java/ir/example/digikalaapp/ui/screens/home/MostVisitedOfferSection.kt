package ir.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.example.digikalaapp.R
import ir.example.digikalaapp.data.model.home.StoreProduct
import ir.example.digikalaapp.data.remote.NetworkResult
import ir.example.digikalaapp.ui.theme.darkText
import ir.example.digikalaapp.ui.theme.spacing
import ir.example.digikalaapp.util.DigitHelper.digitByLocate
import ir.example.digikalaapp.viewmodel.HomeViewModel

@Composable
fun MostVisitedOfferSection(viewModel: HomeViewModel = hiltViewModel()) {


    var mostVisitedList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val mostVisitedResult by viewModel.mostVisitedItems.collectAsState()

    when (mostVisitedResult) {

        is NetworkResult.Success -> {
            loading = true
            mostVisitedList = mostVisitedResult.data ?: emptyList()
        }

        is NetworkResult.Loading -> {
            loading = true
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "Most visited section error: ${mostVisitedResult.message}")
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.small)
    ) {

        Text(
            text = stringResource(id = R.string.best_visited_products),
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText
        )

        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.medium)
                .height(250.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            itemsIndexed(mostVisitedList) { index, item ->
                ProductHorizontalCard(
                    name = item.name,
                    id = digitByLocate((index + 1).toString()),
                    imageUrl = item.image
                )
            }

        }
    }
}