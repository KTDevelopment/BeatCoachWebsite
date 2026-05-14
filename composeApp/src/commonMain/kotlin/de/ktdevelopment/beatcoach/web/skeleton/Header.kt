@file:OptIn(ExperimentalSerializationApi::class)

package de.ktdevelopment.beatcoach.web.skeleton

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import beatcoachwebsite.composeapp.generated.resources.*
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.*
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import de.ktdevelopment.beatcoach.web.theme.deviceSize
import de.ktdevelopment.beatcoach.web.theme.horizontalPagePadding
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource


@Composable
fun Header(
    navController: NavHostController,
    openMobileDrawer: () -> Unit,
) {
    val mainDestinations = listOf(
        AppDestination.Home,
        AppDestination.Features,
        AppDestination.Blog,
    )
    val currentRoute = navController.currentBackStackEntryFlow.collectAsState(null).value?.destination?.route
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
        if (deviceSize in listOf(DeviceSize.Tablet, DeviceSize.Desktop)) {
            Spacer(modifier = Modifier.weight(1f))
            ElevatedCard {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                ) {
                    for (destination in mainDestinations) {
                        val selected = destination.serializer().descriptor.serialName == currentRoute
                        val padding = 16.dp

                        NavButton(
                            modifier = Modifier.padding(horizontal = padding),
                            text = destination.label(),
                            isActive = selected,
                            onClick = { navController.navigate(destination) }
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            modifier = Modifier.cursorHand(),
            onClick = { },
        ) {
            Icon(
                imageVector = LineAwesomeIcons.Android,
                contentDescription = stringResource(Res.string.header__youtube_fallback),
            )
        }
        IconButton(
            modifier = Modifier.cursorHand(),
            onClick = { },
        ) {
            Icon(
                imageVector = LineAwesomeIcons.AppStoreIos,
                contentDescription = stringResource(Res.string.header__youtube_fallback),
            )
        }
        IconButton(
            modifier = Modifier.cursorHand(),
            onClick = { },
        ) {
            Icon(
                imageVector = LineAwesomeIcons.Youtube,
                contentDescription = stringResource(Res.string.header__youtube_fallback),
            )
        }
    }


}

private fun AppDestination.serializer(): KSerializer<out AppDestination> = when (this) {
    AppDestination.Blog -> AppDestination.Blog.serializer()
    AppDestination.Contact -> AppDestination.Contact.serializer()
    AppDestination.Features -> AppDestination.Features.serializer()
    AppDestination.Home -> AppDestination.Home.serializer()
    AppDestination.Impressum -> AppDestination.Impressum.serializer()
    AppDestination.PrivacyPolicy -> AppDestination.PrivacyPolicy.serializer()
}

@Composable
fun AppDestination.label(): String = when (this) {
    AppDestination.Home -> stringResource(Res.string.pages__home__label)
    AppDestination.Features -> stringResource(Res.string.pages__features__label)
    AppDestination.Blog -> stringResource(Res.string.pages__blog__label)
    else -> ""
}

@Composable
fun NavButton(
    modifier: Modifier = Modifier,
    text: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.cursorHand(),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.textButtonColors(
            containerColor = if (isActive) MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.8f)
            else Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Text(text)
    }
}

@Composable
fun NavigationDrawerContent(
    navController: NavHostController,
    closeDrawer: () -> Unit,
) {
    val mainDestinations = listOf(
        AppDestination.Home to LineAwesomeIcons.HomeSolid,
        AppDestination.Features to LineAwesomeIcons.CubesSolid,
        AppDestination.Blog to LineAwesomeIcons.BookOpenSolid,
    )
    val currentRoute = navController.currentBackStackEntryFlow.collectAsState(null).value?.destination?.route

    ModalDrawerSheet {
        Spacer(Modifier.height(12.dp))
        Text("Menü", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)

        for ((destination, icon) in mainDestinations) {
            val selected = destination.serializer().descriptor.serialName == currentRoute

            NavigationDrawerItem(
                label = { Text(destination.label()) },
                selected = selected,
                onClick = {
                    navController.navigate(destination)
                    closeDrawer()
                },
                icon = { Icon(icon, contentDescription = null) },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}
