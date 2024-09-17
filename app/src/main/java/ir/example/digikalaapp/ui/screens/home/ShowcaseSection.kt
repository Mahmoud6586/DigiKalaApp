package ir.example.digikalaapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.digikala.ui.component.RoundedIconBox
import ir.example.digikalaapp.R
import ir.example.digikalaapp.navigation.Screen
import ir.example.digikalaapp.ui.theme.LocalSpacing
import ir.example.digikalaapp.ui.theme.amber
import ir.example.digikalaapp.ui.theme.grayCategory
import ir.example.digikalaapp.util.Constants.AUCTION_URL
import ir.example.digikalaapp.util.Constants.DIGIJET_URL
import ir.example.digikalaapp.util.Constants.DIGIPAY_URL
import ir.example.digikalaapp.util.Constants.DIGIPLUS_URL
import ir.example.digikalaapp.util.Constants.GIFT_CARD_URL
import ir.example.digikalaapp.util.Constants.MORE_URL
import ir.example.digikalaapp.util.Constants.PINDO_URL
import ir.example.digikalaapp.util.Constants.SHOPPING_URL

@Composable
fun ShowcaseSection(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = LocalSpacing.current.semiMedium,
                vertical = LocalSpacing.current.biggerSmall
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            RoundedIconBox(
                onClick = onBoxClick(navController = navController, url = DIGIJET_URL),
                title = stringResource(id = R.string.digikala_jet), image = painterResource(
                    id = R.drawable.digijet

                )
            )
            RoundedIconBox(
                onClick = onBoxClick(navController = navController, url = AUCTION_URL),
                title = stringResource(id = R.string.digi_style), image = painterResource(
                    id = R.drawable.auction

                )
            )
            RoundedIconBox(
                onClick = onBoxClick(navController = navController, url = DIGIPAY_URL),
                title = stringResource(id = R.string.digi_pay), image = painterResource(
                    id = R.drawable.digipay

                )
            )
            RoundedIconBox(
                onClick = onBoxClick(navController = navController, url = PINDO_URL),
                bgColor = MaterialTheme.colors.amber,
                title = stringResource(id = R.string.pindo), image = painterResource(
                    id = R.drawable.pindo,


                    )
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            RoundedIconBox(
                onClick = onBoxClick(navController = navController, url = SHOPPING_URL),
                title = stringResource(id = R.string.digi_shopping), image = painterResource(
                    id = R.drawable.shopping

                )
            )
            RoundedIconBox(
                onClick = onBoxClick(navController = navController, url = GIFT_CARD_URL),
                title = stringResource(id = R.string.gift_card), image = painterResource(
                    id = R.drawable.giftcard

                )
            )
            RoundedIconBox(
                onClick = onBoxClick(navController = navController, url = DIGIPLUS_URL),
                title = stringResource(id = R.string.digi_plus), image = painterResource(
                    id = R.drawable.digiplus

                )
            )
            RoundedIconBox(
                onClick = onBoxClick(navController = navController, url = MORE_URL),
                bgColor = MaterialTheme.colors.grayCategory,
                title = stringResource(id = R.string.more), image = painterResource(
                    id = R.drawable.more

                )
            )

        }

    }

}

@Composable
fun onBoxClick(navController: NavController, url: String): () -> Unit =
    { navController.navigate(route = Screen.WebView.route + "?url=${url}") }