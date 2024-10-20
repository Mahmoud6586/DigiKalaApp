package ir.example.digikalaapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import ir.example.digikalaapp.R
import ir.example.digikalaapp.data.model.home.MainCategory
import ir.example.digikalaapp.data.remote.NetworkResult
import ir.example.digikalaapp.ui.theme.darkText
import ir.example.digikalaapp.ui.theme.spacing
import ir.example.digikalaapp.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryListSection(viewModel: HomeViewModel = hiltViewModel()) {

    var categoryList by remember {
        mutableStateOf<List<MainCategory>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val categoryResult by viewModel.categories.collectAsState()

    when (categoryResult) {
        is NetworkResult.Success -> {
            categoryList = categoryResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Loading -> {
            loading = true
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "Categories section error: ${categoryResult.message}")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
    ) {
        Text(
            text = stringResource(id = R.string.category_title),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.medium),
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText
        )

        FlowRow(
            maxItemsInEachRow = 3,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            for (item in categoryList) {
                CircularCategoryItem(item = item)
            }
        }
    }
}

@Composable
fun CircularCategoryItem(item: MainCategory) {

    Column(
        modifier = Modifier.size(100.dp, 160.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = rememberAsyncImagePainter(model = item.image),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(vertical = MaterialTheme.spacing.extraSmall)
        )
        Text(
            text = item.name,
            color = MaterialTheme.colors.darkText,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.extraSmall)
        )
    }
}