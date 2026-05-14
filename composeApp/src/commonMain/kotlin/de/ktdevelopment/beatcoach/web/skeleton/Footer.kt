package de.ktdevelopment.beatcoach.web.skeleton

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import beatcoachwebsite.composeapp.generated.resources.*
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import de.ktdevelopment.beatcoach.web.theme.deviceSize
import org.jetbrains.compose.resources.stringResource

@Composable
fun Footer(navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
    ) {
        val deviceSize = deviceSize()
        when (deviceSize) {
            DeviceSize.Smartphone -> SmallFooter(navController)
            DeviceSize.Tablet, DeviceSize.Desktop, DeviceSize.LargeDesktop -> NormalFooter(navController)
        }
    }
}

@Composable
private fun SmallFooter(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FooterLinks(navController)
        Spacer(modifier = Modifier.height(8.dp))
        CreatorLabel()
    }
}

@Composable
private fun NormalFooter(navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CreatorLabel()
        FooterLinks(navController)
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
private fun FooterLinks(
    navController: NavHostController,
) {
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
