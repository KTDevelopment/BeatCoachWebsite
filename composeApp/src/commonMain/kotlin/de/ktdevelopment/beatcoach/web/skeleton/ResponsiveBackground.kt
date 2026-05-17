package de.ktdevelopment.beatcoach.web.skeleton

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.deviceSize

@Composable
fun ResponsiveBackground(
    content: @Composable BoxScope.() -> Unit
) {
    val gradientColors = if (isSystemInDarkTheme()) {
        listOf(
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.surfaceContainer,
            MaterialTheme.colorScheme.onPrimary,
        )
    } else {
        listOf(
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.secondaryContainer,
            MaterialTheme.colorScheme.primaryContainer,
        )
    }
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            )
    ) {
        val isSmartphone = deviceSize() == DeviceSize.Smartphone

        Box(
            modifier = Modifier
                .size(if (isSmartphone) 200.dp else 400.dp)
                .offset(
                    x = if (isSmartphone) maxWidth - 100.dp else maxWidth - 200.dp,
                    y = if (isSmartphone) 80.dp else 100.dp
                )
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.tertiaryContainer,
                            Color.Transparent
                        )
                    )
                )
        )

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            content()
        }
    }
}
