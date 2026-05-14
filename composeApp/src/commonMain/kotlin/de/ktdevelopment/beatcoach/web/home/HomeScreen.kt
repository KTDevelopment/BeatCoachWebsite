package de.ktdevelopment.beatcoach.web.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.*
import de.ktdevelopment.beatcoach.web.Platform
import de.ktdevelopment.beatcoach.web.skeleton.androidAppLink
import de.ktdevelopment.beatcoach.web.skeleton.iosAppLink
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import de.ktdevelopment.beatcoach.web.theme.deviceSize
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.padding(top = HomePaddingTop()),
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,
            itemVerticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.widthIn(max = 600.dp).padding(bottom = 32.dp),
            ) {
                Text(
                    text = stringResource(Res.string.pages__home__hero__header),
                    style = MaterialTheme.typography.displayLarge,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = stringResource(Res.string.pages__home__hero__text),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Button(
                        modifier = Modifier.cursorHand(),
                        onClick = { Platform.openInternetUrl(androidAppLink.url) }
                    ) {
                        Icon(
                            imageVector = androidAppLink.icon,
                            contentDescription = stringResource(androidAppLink.description),
                        )
                        Text(text = stringResource(Res.string.pages__home__android__button__label))
                    }
                    Spacer(modifier = Modifier.width(32.dp))
                    Button(
                        modifier = Modifier.cursorHand(),
                        onClick = { Platform.openInternetUrl(iosAppLink.url) }
                    ) {
                        Icon(
                            imageVector = iosAppLink.icon,
                            contentDescription = stringResource(iosAppLink.description),
                        )
                        Text(text = stringResource(Res.string.pages__home__ios__button__label))
                    }
                }
            }
            Box(modifier = Modifier.padding(start = MainImagePaddingStart())) {
                Spacer(modifier = Modifier.size(460.dp))
                Image(
                    painter = painterResource(Res.drawable.met_dark),
                    contentDescription = "Beschreibung meines Bildes",
                    modifier = Modifier
                        .sizeIn(maxWidth = 700.dp, maxHeight = 500.dp)
                        .offset(x = 225.dp, y = 50.dp)
                )

                Image(
                    painter = painterResource(Res.drawable.met_light),
                    contentDescription = "Beschreibung meines Bildes",
                    modifier = Modifier
                        .sizeIn(maxWidth = 800.dp, maxHeight = 600.dp)

                )
            }
        }
    }
}

@Composable
private fun HomePaddingTop(): Dp {
    val deviceSize = deviceSize()
    return when (deviceSize) {
        DeviceSize.Smartphone -> 16.dp
        DeviceSize.Tablet -> 16.dp
        DeviceSize.Desktop -> 64.dp
        DeviceSize.LargeDesktop -> 64.dp
    }
}

@Composable
private fun MainImagePaddingStart(): Dp {
    val deviceSize = deviceSize()
    return when (deviceSize) {
        DeviceSize.Smartphone -> 0.dp
        DeviceSize.Tablet -> 16.dp
        DeviceSize.Desktop -> 28.dp
        DeviceSize.LargeDesktop -> 64.dp
    }
}

