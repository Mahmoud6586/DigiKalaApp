package ir.example.digikalaapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.example.digikalaapp.R
import ir.example.digikalaapp.ui.theme.DarkCyan
import ir.example.digikalaapp.ui.theme.DigikalaLightRed
import ir.example.digikalaapp.ui.theme.darkText
import ir.example.digikalaapp.ui.theme.roundedShape
import ir.example.digikalaapp.ui.theme.spacing
import java.lang.reflect.Modifier

@Composable
fun MostFavoriteProductShowMore() {
    Column(
        modifier = androidx.compose.ui.Modifier
            .size(180.dp, 375.dp)
            .background(Color.White)
            .padding(
                end = MaterialTheme.spacing.medium,
                start = MaterialTheme.spacing.semiSmall,
                top = MaterialTheme.spacing.semiLarge
            ),
    ) {
        Column(
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.show_more),
                contentDescription = "",
                tint = MaterialTheme.colors.DarkCyan,
                modifier = androidx.compose.ui.Modifier.size(40.dp, 40.dp)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(20.dp))

            androidx.compose.material3.Text(
                text = stringResource(id = R.string.see_all),
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText
            )
        }

    }

}