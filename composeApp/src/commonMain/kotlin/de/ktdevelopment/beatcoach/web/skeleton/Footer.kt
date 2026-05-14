package de.ktdevelopment.beatcoach.web.skeleton

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.*
import de.ktdevelopment.beatcoach.web.LocalNavController
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import de.ktdevelopment.beatcoach.web.theme.deviceSize
import org.jetbrains.compose.resources.stringResource

@Composable
fun Footer() {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        val deviceSize = deviceSize()
        when (deviceSize) {
            DeviceSize.Smartphone -> SmallFooter()
            DeviceSize.Tablet, DeviceSize.Desktop, DeviceSize.LargeDesktop -> NormalFooter()
        }
    }
}

@Composable
private fun SmallFooter() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FooterLinks()
        Spacer(modifier = Modifier.height(8.dp))
        CreatorLabel()
    }
}

@Composable
private fun NormalFooter() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CreatorLabel()
        FooterLinks()
    }
}

@Composable
private fun CreatorLabel() {
    Text(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        text = stringResource(Res.string.footer__created_label),
        style = MaterialTheme.typography.bodySmall,
    )
}

@Composable
private fun FooterLinks() {
    val navController = LocalNavController.current
    Row {
        val padding = 8.dp
        TextButton(
            modifier = Modifier.cursorHand().padding(horizontal = padding),
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colorScheme.onBackground
            ),
            onClick = { navController.navigate(AppDestination.PrivacyPolicy) }) {
            Text(stringResource(Res.string.pages__privacy__label))
        }
        TextButton(
            modifier = Modifier.cursorHand().padding(horizontal = padding),
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colorScheme.onBackground
            ),
            onClick = { navController.navigate(AppDestination.Impressum) }) {
            Text(stringResource(Res.string.pages__impressum__label))
        }
        TextButton(
            modifier = Modifier.cursorHand().padding(horizontal = padding),
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colorScheme.onBackground
            ),
            onClick = { navController.navigate(AppDestination.Contact) }) {
            Text(stringResource(Res.string.pages__contact__label))
        }
    }
}
