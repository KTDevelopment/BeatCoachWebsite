package de.ktdevelopment.beatcoach.web.skeleton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.deviceSize

@Composable
fun PageContainer(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(top = paddingTop()),
    ) {
        content()
        Spacer(Modifier.height(64.dp))
        Footer()
        Spacer(Modifier.height(64.dp))
    }
}


@Composable
private fun paddingTop(): Dp {
    val deviceSize = deviceSize()
    return when (deviceSize) {
        DeviceSize.Smartphone -> 16.dp
        DeviceSize.Tablet -> 16.dp
        DeviceSize.Desktop -> 64.dp
        DeviceSize.LargeDesktop -> 64.dp
    }
}
