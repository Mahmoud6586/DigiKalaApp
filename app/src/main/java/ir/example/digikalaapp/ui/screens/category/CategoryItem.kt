package ir.example.digikalaapp.ui.screens.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import ir.example.digikalaapp.R
import ir.example.digikalaapp.data.model.category.Sub
import ir.example.digikalaapp.ui.theme.LightCyan
import ir.example.digikalaapp.ui.theme.spacing
import java.lang.reflect.Modifier

@Composable
fun CategoryItem(title: String, subList: List<Sub>) {

    Row(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(
                top = MaterialTheme.spacing.medium,
                bottom = MaterialTheme.spacing.small,
                start = MaterialTheme.spacing.small,
                end = MaterialTheme.spacing.small
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = MaterialTheme.typography.body2, fontWeight = FontWeight.Bold)
        Text(
            text = stringResource(id = R.string.see_all),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.LightCyan
        )

    }

    LazyRow {
        items(subList) { list ->
            SubCategoryItem(item = list)
        }
    }
}