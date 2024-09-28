package ir.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import ir.example.digikalaapp.data.model.home.Slider
import ir.example.digikalaapp.data.remote.NetworkResult
import ir.example.digikalaapp.ui.theme.roundedShape
import ir.example.digikalaapp.ui.theme.spacing
import ir.example.digikalaapp.viewmodel.HomeViewModel
import java.lang.reflect.Modifier

@OptIn(ExperimentalLayoutApi::class)
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

    FlowRow(
        maxItemsInEachRow = 2,
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .height(290.dp)
            .padding(MaterialTheme.spacing.small)
    ) {
        for (item in bannersList) {
            ProposalCardItem(imgLink = item)
        }
    }
}

@Composable
fun ProposalCardItem(imgLink: Slider) {
    Card(
        shape = MaterialTheme.roundedShape.semiMedium,
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth(0.5f)
            .height(140.dp)
            .padding(
                horizontal = MaterialTheme.spacing.small,
                vertical = MaterialTheme.spacing.small
            )
    ) {

        Image(
            painter = rememberAsyncImagePainter(model = imgLink.image),
            contentDescription = null,
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

    }
}