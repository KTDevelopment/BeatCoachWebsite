@file:OptIn(ExperimentalSerializationApi::class)

package de.ktdevelopment.beatcoach.web.skeleton.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.beatcoach_wortmarke_lila
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.BarsSolid
import de.ktdevelopment.beatcoach.web.LocalNavController
import de.ktdevelopment.beatcoach.web.skeleton.AppDestination
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import de.ktdevelopment.beatcoach.web.theme.deviceSize
import de.ktdevelopment.beatcoach.web.theme.horizontalPagePadding
import kotlinx.serialization.ExperimentalSerializationApi
import org.jetbrains.compose.resources.vectorResource


@Composable
fun Header(
    openMobileDrawer: () -> Unit,
) {
    val navController = LocalNavController.current
    val deviceSize = deviceSize()
    Row(
        modifier = Modifier
            .padding(start = horizontalPagePadding(), end = horizontalPagePadding(), top = 16.dp, bottom = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (deviceSize === DeviceSize.Smartphone) {
            IconButton(onClick = openMobileDrawer) {
                Icon(LineAwesomeIcons.BarsSolid, contentDescription = null)
            }
            Spacer(modifier = Modifier.weight(1f))
        }
        Image(
            modifier = Modifier
                .width(240.dp)
                .cursorHand()
                .clickable { navController.navigate(AppDestination.Home) },
            imageVector = vectorResource(Res.drawable.beatcoach_wortmarke_lila),
            contentDescription = "BeatCoach Logo",
        )
        if (deviceSize in listOf(DeviceSize.Tablet, DeviceSize.Desktop, DeviceSize.LargeDesktop)) {
            Spacer(modifier = Modifier.weight(0.8f))
            TopNavigation()
        }
        Spacer(modifier = Modifier.weight(1f))
        if (deviceSize in listOf(DeviceSize.Tablet, DeviceSize.Desktop, DeviceSize.LargeDesktop)) {
            SocialLinksRow()
        } else {
            SocialLinksMenu()
        }
    }
}

