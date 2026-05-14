@file:OptIn(ExperimentalSerializationApi::class)

package de.ktdevelopment.beatcoach.web.skeleton.header

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.ktdevelopment.beatcoach.web.LocalNavController
import de.ktdevelopment.beatcoach.web.skeleton.AppDestination
import de.ktdevelopment.beatcoach.web.skeleton.label
import de.ktdevelopment.beatcoach.web.skeleton.serializer
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import kotlinx.serialization.ExperimentalSerializationApi

@Composable
fun TopNavigation() {
    val mainDestinations = listOf(
        AppDestination.Home,
        AppDestination.Features,
        AppDestination.Blog,
    )
    val navController = LocalNavController.current
    val currentRoute = navController.currentBackStackEntryFlow.collectAsState(null).value?.destination?.route

    ElevatedCard {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            for (destination in mainDestinations) {
                val selected = destination.serializer().descriptor.serialName == currentRoute
                val padding = 16.dp

                TopNavigationButton(
                    modifier = Modifier.padding(horizontal = padding),
                    text = destination.label(),
                    isActive = selected,
                    onClick = { navController.navigate(destination) }
                )
            }
        }
    }
}

@Composable
private fun TopNavigationButton(
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
