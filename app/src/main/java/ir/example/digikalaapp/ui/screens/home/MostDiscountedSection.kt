package ir.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.example.digikalaapp.R
import ir.example.digikalaapp.data.model.home.StoreProduct
import ir.example.digikalaapp.data.remote.NetworkResult
import ir.example.digikalaapp.ui.theme.darkText
import ir.example.digikalaapp.viewmodel.HomeViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MostDiscountedSection(
    viewModel: HomeViewModel = hiltViewModel(),
) {

    var mostDiscountedList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val mostDiscountedResult by viewModel.mostDiscountedItems.collectAsState()

    when (mostDiscountedResult) {

        is NetworkResult.Success -> {
            loading = false
            mostDiscountedList = mostDiscountedResult.data ?: emptyList()
        }

        is NetworkResult.Loading -> {
            loading = true
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "Most Discounted Section Error : ${mostDiscountedResult.message}")
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(

            text = stringResource(id = R.string.most_discount_products),
            textAlign = TextAlign.Right,
            style = androidx.compose.material.MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.SemiBold,
            color = androidx.compose.material.MaterialTheme.colors.darkText
        )

        FlowRow(
            maxItemsInEachRow = 2, modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start
        ) {
            for(item in mostDiscountedList){
                MostDiscountedCard(item)
            }
        }
    }
}