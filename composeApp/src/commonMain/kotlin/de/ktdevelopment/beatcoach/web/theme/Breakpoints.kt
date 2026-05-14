package de.ktdevelopment.beatcoach.web.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class DeviceSize {
    Smartphone,
    Tablet,
    Desktop,
    LargeDesktop,
}

@Composable
fun deviceSize(): DeviceSize {
    val screenWidth = LocalWindowInfo.current.containerSize.width
    return when (screenWidth) {
        in 0..792 * 2 -> DeviceSize.Smartphone
        in 793 * 2..1280 * 2 -> DeviceSize.Tablet
        in 1281 * 2..1920 * 2 -> DeviceSize.Desktop
        else -> DeviceSize.LargeDesktop
    }
}

@Composable
fun screenHeight() = LocalWindowInfo.current.containerSize.height.dp

@Composable
fun horizontalPagePadding(): Dp = when (deviceSize()) {
    DeviceSize.Smartphone -> 16.dp
    DeviceSize.Tablet -> 16.dp * 2
    DeviceSize.Desktop -> 32.dp * 3
    DeviceSize.LargeDesktop -> 64.dp * 3
}
