package ir.example.digikalaapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ir.example.digikalaapp.ui.theme.roundedShape
import ir.example.digikalaapp.ui.theme.spacing

@Composable
fun CenterBannerItem(imgUrl: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(androidx.compose.material.MaterialTheme.spacing.medium),
        shape = androidx.compose.material.MaterialTheme.roundedShape.semiMedium
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = imgUrl),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}