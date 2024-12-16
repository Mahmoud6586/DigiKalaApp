package ir.example.digikalaapp.ui.screens.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ir.example.digikalaapp.R
import ir.example.digikalaapp.data.model.category.Sub
import ir.example.digikalaapp.ui.theme.darkText
import ir.example.digikalaapp.ui.theme.grayCategory
import ir.example.digikalaapp.ui.theme.roundedShape
import ir.example.digikalaapp.ui.theme.spacing

@Composable
fun SubCategoryItem(item: Sub) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .padding(
                vertical = MaterialTheme.spacing.medium,
                horizontal = MaterialTheme.spacing.extraSmall
            ),
        shape = MaterialTheme.roundedShape.small
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.grayCategory)
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.semiMedium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = item.image),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = item.name,
                modifier = Modifier.fillMaxWidth().padding(start = MaterialTheme.spacing.small),
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                color = Color.Gray,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Normal,
                text = "+${item.count} ${stringResource(id = R.string.commodity)}"
            )
        }
    }
}