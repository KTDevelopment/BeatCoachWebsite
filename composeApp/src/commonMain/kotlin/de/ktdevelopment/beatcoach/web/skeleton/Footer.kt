package de.ktdevelopment.beatcoach.web.skeleton

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.footer__created_label
import beatcoachwebsite.composeapp.generated.resources.pages__impressum__label
import beatcoachwebsite.composeapp.generated.resources.pages__privacy__label
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import de.ktdevelopment.beatcoach.web.theme.horizontalPagePadding
import org.jetbrains.compose.resources.stringResource

@Composable
fun Footer(navController: NavHostController) {
    Row(
        modifier = Modifier
            .padding(start = horizontalPagePadding(), end = horizontalPagePadding(), top = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(stringResource(Res.string.footer__created_label))

        val paddingEnd = 16.dp
        TextButton(
            modifier = Modifier.cursorHand().padding(end = paddingEnd),
            onClick = { navController.navigate(AppDestination.PrivacyPolicy) }) {
            Text(stringResource(Res.string.pages__privacy__label))
        }
        TextButton(
            modifier = Modifier.cursorHand().padding(end = paddingEnd),
            onClick = { navController.navigate(AppDestination.Impressum) }) {
            Text(stringResource(Res.string.pages__impressum__label))
        }
    }
}
