@file:OptIn(ExperimentalSerializationApi::class)

package de.ktdevelopment.beatcoach.web.skeleton.header

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.BookOpenSolid
import compose.icons.lineawesomeicons.CubesSolid
import compose.icons.lineawesomeicons.HomeSolid
import de.ktdevelopment.beatcoach.web.skeleton.AppDestination
import de.ktdevelopment.beatcoach.web.skeleton.label
import de.ktdevelopment.beatcoach.web.skeleton.serializer
import kotlinx.serialization.ExperimentalSerializationApi

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
