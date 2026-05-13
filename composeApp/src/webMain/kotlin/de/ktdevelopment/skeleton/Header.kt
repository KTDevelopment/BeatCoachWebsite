package de.ktdevelopment.skeleton

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import beatcoachwebsite.composeapp.generated.resources.*
import de.ktdevelopment.theme.DeviceSize
import de.ktdevelopment.theme.cursorHand
import de.ktdevelopment.theme.deviceSize
import de.ktdevelopment.theme.horizontalPagePadding
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource


@Composable
fun Header(
    navController: NavHostController,
) {
    Row(
        modifier = Modifier
            .padding(start = horizontalPagePadding(), end = horizontalPagePadding(), top = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .width(240.dp)
                .cursorHand()
                .clickable { navController.navigate(AppDestination.Home) },
            imageVector = vectorResource(Res.drawable.beatcoach_wortmarke_lila),
            contentDescription = "BeatCoach Logo",
        )
        val startPaddingForNavMenu = when (deviceSize()) {
            DeviceSize.Smartphone -> 0.dp
            DeviceSize.Tablet -> 64.dp
            DeviceSize.Desktop -> 64.dp * 3
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = startPaddingForNavMenu),
            horizontalArrangement = Arrangement.Start,
        ) {
            ElevatedCard {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                ) {
                    val paddingEnd = 16.dp
                    TextButton(
                        modifier = Modifier.cursorHand().padding(end = paddingEnd),
                        onClick = { navController.navigate(AppDestination.Home) }) {
                        Text(stringResource(Res.string.pages__home__label))
                    }
                    TextButton(
                        modifier = Modifier.cursorHand().padding(end = paddingEnd),
                        onClick = { navController.navigate(AppDestination.Features) }) {
                        Text(stringResource(Res.string.pages__features__label))
                    }
                    TextButton(
                        modifier = Modifier.cursorHand().padding(end = paddingEnd),
                        onClick = { navController.navigate(AppDestination.Blog) }) {
                        Text(stringResource(Res.string.pages__blog__label))
                    }
                    TextButton(
                        modifier = Modifier.cursorHand(),
                        onClick = { navController.navigate(AppDestination.Contact) }
                    ) {
                        Text(stringResource(Res.string.pages__contact__label))
                    }
                }
            }
        }
    }
}
