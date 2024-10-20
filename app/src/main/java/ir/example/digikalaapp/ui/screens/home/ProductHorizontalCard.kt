package ir.example.digikalaapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ir.example.digikalaapp.data.model.home.StoreProduct
import ir.example.digikalaapp.ui.theme.DarkCyan
import ir.example.digikalaapp.ui.theme.darkText
import ir.example.digikalaapp.ui.theme.spacing

@Composable
fun ProductHorizontalCard(name: String, id: String, imageUrl: String) {

    Row(
        modifier = Modifier
            .width(320.dp)
            .padding(bottom = MaterialTheme.spacing.extraSmall),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
            contentDescription = "",
            modifier = Modifier
                .weight(0.3f)
                .fillMaxHeight()
        )
        Text(
            text = id,
            modifier = Modifier
                .weight(.1f)
                .padding(horizontal = MaterialTheme.spacing.small),
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.DarkCyan,
            style = MaterialTheme.typography.h4
        )
        Column(
            modifier = Modifier
                .weight(.6f)
                .fillMaxHeight()
                .padding(vertical = MaterialTheme.spacing.small)
        ) {

            Text(
                text = name,
                color = MaterialTheme.colors.darkText,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = MaterialTheme.spacing.small),
                style = MaterialTheme.typography.subtitle2
            )
        }

    }
}