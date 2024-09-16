package ir.example.digikalaapp.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.example.digikalaapp.R
import ir.example.digikalaapp.ui.component.RoundedIconBox
import ir.example.digikalaapp.ui.theme.LocalSpacing

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
                title = stringResource(id = R.string.digikala_jet), image = painterResource(
                    id = R.drawable.digijet

                )
            ) {}
            RoundedIconBox(
                title = stringResource(id = R.string.digikala_jet), image = painterResource(
                    id = R.drawable.digijet

                )
            ) {}
            RoundedIconBox(
                title = stringResource(id = R.string.digikala_jet), image = painterResource(
                    id = R.drawable.digijet

                )
            ) {}
            RoundedIconBox(
                title = stringResource(id = R.string.digikala_jet), image = painterResource(
                    id = R.drawable.digijet

                )
            ) {}

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            RoundedIconBox(
                title = stringResource(id = R.string.digikala_jet), image = painterResource(
                    id = R.drawable.digijet

                )
            ) {}
            RoundedIconBox(
                title = stringResource(id = R.string.digikala_jet), image = painterResource(
                    id = R.drawable.digijet

                )
            ) {}
            RoundedIconBox(
                title = stringResource(id = R.string.digikala_jet), image = painterResource(
                    id = R.drawable.digijet

                )
            ) {}
            RoundedIconBox(
                title = stringResource(id = R.string.digikala_jet), image = painterResource(
                    id = R.drawable.digijet

                )
            ) {}

        }

    }

}