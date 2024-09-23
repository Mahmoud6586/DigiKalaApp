package ir.example.digikalaapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.example.digikalaapp.R
import ir.example.digikalaapp.ui.theme.DigikalaLightRed
import ir.example.digikalaapp.ui.theme.darkText
import ir.example.digikalaapp.ui.theme.roundedShape
import ir.example.digikalaapp.ui.theme.spacing

@Composable
fun AmazingShowMoreItem() {
    Card(
        modifier = Modifier
            .size(180.dp, 375.dp)
            .padding(
                end = MaterialTheme.spacing.medium,
                start = MaterialTheme.spacing.semiSmall,
                top = MaterialTheme.spacing.semiLarge
            ),
        shape = MaterialTheme.roundedShape.small,
        colors = CardDefaults.cardColors(contentColor = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.show_more),
                contentDescription = "",
                tint = MaterialTheme.colors.DigikalaLightRed,
                modifier = Modifier.size(40.dp, 40.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.see_all),
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText
            )
        }

    }
}