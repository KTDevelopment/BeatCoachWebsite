package de.ktdevelopment.beatcoach.web.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.*
import de.ktdevelopment.beatcoach.web.Platform.openInternetUrl
import de.ktdevelopment.beatcoach.web.skeleton.header.androidAppLink
import de.ktdevelopment.beatcoach.web.skeleton.header.iosAppLink
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import de.ktdevelopment.beatcoach.web.theme.deviceSize
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun HeroContent() {
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
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                itemVerticalAlignment = Alignment.CenterVertically,
            ) {
                for (link in listOf(androidAppLink, iosAppLink)) {
                    Button(
                        modifier = Modifier.cursorHand().padding(16.dp),
                        onClick = { openInternetUrl(link.url) }
                    ) {
                        Icon(
                            imageVector = link.icon,
                            contentDescription = stringResource(link.description),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = stringResource(link.buttonLabel))
                    }
                }
            }
        }
        Box(modifier = Modifier.padding(start = MainImagePaddingStart())) {
            val baseMaxWidth = MainImageMaxWidth()
            val offset = MainImageOffset()
            Spacer(modifier = Modifier.size(MainImageContainerWidth()))
            Image(
                painter = painterResource(Res.drawable.met_dark),
                contentDescription = "Beschreibung meines Bildes",
                modifier = Modifier
                    .sizeIn(maxWidth = baseMaxWidth, maxHeight = baseMaxWidth - 200.dp)
                    .offset(x = offset.x.dp, y = offset.y.dp)
            )

            Image(
                painter = painterResource(Res.drawable.met_light),
                contentDescription = "Beschreibung meines Bildes",
                modifier = Modifier
                    .sizeIn(maxWidth = baseMaxWidth + 100.dp, maxHeight = baseMaxWidth - 100.dp)

            )
        }
    }
}

@Composable
private fun MainImagePaddingStart(): Dp = when (deviceSize()) {
    DeviceSize.Smartphone -> 0.dp
    DeviceSize.Tablet -> 16.dp
    DeviceSize.Desktop -> 28.dp
    DeviceSize.LargeDesktop -> 64.dp
}

@Composable
private fun MainImageContainerWidth(): Dp = when (deviceSize()) {
    DeviceSize.Smartphone -> 310.dp
    DeviceSize.Tablet -> 460.dp
    DeviceSize.Desktop -> 460.dp
    DeviceSize.LargeDesktop -> 460.dp
}

@Composable
private fun MainImageMaxWidth(): Dp = when (deviceSize()) {
    DeviceSize.Smartphone -> 500.dp
    DeviceSize.Tablet -> 700.dp
    DeviceSize.Desktop -> 700.dp
    DeviceSize.LargeDesktop -> 700.dp
}

@Composable
private fun MainImageOffset(): Offset = when (deviceSize()) {
    DeviceSize.Smartphone -> Offset(x = 170f, y = 50f)
    DeviceSize.Tablet -> Offset(x = 225f, y = 50f)
    DeviceSize.Desktop -> Offset(x = 225f, y = 50f)
    DeviceSize.LargeDesktop -> Offset(x = 225f, y = 50f)
}
