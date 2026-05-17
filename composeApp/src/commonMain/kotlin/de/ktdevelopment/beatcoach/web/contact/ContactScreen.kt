package de.ktdevelopment.beatcoach.web.contact

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.pages__contact__email_button__label
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.Envelope
import de.ktdevelopment.beatcoach.web.Platform
import de.ktdevelopment.beatcoach.web.shared.MarkdownRenderer
import de.ktdevelopment.beatcoach.web.skeleton.PageContainer
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import org.jetbrains.compose.resources.stringResource


@Composable
fun ContactScreen() {
    PageContainer {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MarkdownRenderer("kontakt.md")
            Spacer(modifier = Modifier.height(48.dp))
            Button(
                modifier = Modifier.cursorHand(),
                onClick = {
                    Platform.sendEmailTo("beatcoach@web.de")
                }
            ) {
                Icon(
                    imageVector = LineAwesomeIcons.Envelope,
                    contentDescription = stringResource(Res.string.pages__contact__email_button__label),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = stringResource(Res.string.pages__contact__email_button__label))
            }
            Spacer(modifier = Modifier.height(120.dp))
        }
    }
}
