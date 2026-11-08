package de.ktdevelopment.beatcoach.web.features.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.pages__features__cta__text
import beatcoachwebsite.composeapp.generated.resources.pages__features__cta__title
import de.ktdevelopment.beatcoach.web.Platform.openInternetUrl
import de.ktdevelopment.beatcoach.web.skeleton.header.androidAppLink
import de.ktdevelopment.beatcoach.web.skeleton.header.iosAppLink
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import org.jetbrains.compose.resources.stringResource

@Composable
fun FeaturesCta(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(Res.string.pages__features__cta__title),
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(Res.string.pages__features__cta__text),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(24.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            itemVerticalAlignment = Alignment.CenterVertically,
        ) {
            for (link in listOf(androidAppLink, iosAppLink)) {
                Button(
                    modifier = Modifier.cursorHand().padding(horizontal = 8.dp, vertical = 8.dp),
                    onClick = { openInternetUrl(link.url) },
                ) {
                    Icon(
                        imageVector = link.icon,
                        contentDescription = stringResource(link.description),
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(link.buttonLabel))
                }
            }
        }
    }
}
