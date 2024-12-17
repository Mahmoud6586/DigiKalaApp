package ir.example.digikalaapp.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import ir.example.digikalaapp.R
import ir.example.digikalaapp.data.model.home.StoreProduct
import ir.example.digikalaapp.data.remote.NetworkResult
import ir.example.digikalaapp.ui.screens.home.MostDiscountedCard
import ir.example.digikalaapp.ui.theme.darkText
import ir.example.digikalaapp.ui.theme.searchBarBg
import ir.example.digikalaapp.ui.theme.spacing
import ir.example.digikalaapp.viewmodel.BasketViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SuggestListSection(viewModel: BasketViewModel = hiltViewModel()) {


    viewModel.getSuggestedItems()

    var suggestedList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val suggestedItemResult by viewModel.suggestedList.collectAsState()

    when (suggestedItemResult) {
        is NetworkResult.Loading -> {
            loading = true
        }

        is NetworkResult.Success -> {
            suggestedList = suggestedItemResult.data ?: emptyList()

            loading = false
        }

        is NetworkResult.Error -> {
            Log.e("3636", "Suggested List Error : ${suggestedItemResult.message}")
            loading = false
        }
    }

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.spacing.small)
            .background(MaterialTheme.colors.searchBarBg)
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.medium),
        text = stringResource(id = R.string.suggestion_for_you),
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
        for (item in suggestedList) {
            MostDiscountedCard(item)
        }
    }


}