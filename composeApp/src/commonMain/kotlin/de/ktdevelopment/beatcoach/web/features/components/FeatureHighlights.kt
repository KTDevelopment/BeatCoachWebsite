package de.ktdevelopment.beatcoach.web.features.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.pages__features__highlights__1__text
import beatcoachwebsite.composeapp.generated.resources.pages__features__highlights__1__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__highlights__2__text
import beatcoachwebsite.composeapp.generated.resources.pages__features__highlights__2__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__highlights__3__text
import beatcoachwebsite.composeapp.generated.resources.pages__features__highlights__3__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__highlights__4__text
import beatcoachwebsite.composeapp.generated.resources.pages__features__highlights__4__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__highlights__title
import de.ktdevelopment.beatcoach.web.features.model.FeatureHighlight
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.deviceSize
import org.jetbrains.compose.resources.stringResource

@Composable
fun FeatureHighlights(modifier: Modifier = Modifier) {
    val highlights = listOf(
        FeatureHighlight(Res.string.pages__features__highlights__1__title, Res.string.pages__features__highlights__1__text),
        FeatureHighlight(Res.string.pages__features__highlights__2__title, Res.string.pages__features__highlights__2__text),
        FeatureHighlight(Res.string.pages__features__highlights__3__title, Res.string.pages__features__highlights__3__text),
        FeatureHighlight(Res.string.pages__features__highlights__4__title, Res.string.pages__features__highlights__4__text),
    )
    val columns = when (deviceSize()) {
        DeviceSize.Smartphone -> 1
        DeviceSize.Tablet -> 2
        DeviceSize.Desktop, DeviceSize.LargeDesktop -> 4
    }
    val spacing = 16.dp

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(Res.string.pages__features__highlights__title),
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(20.dp))
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            val itemWidth = if (columns == 1) maxWidth else (maxWidth - spacing * (columns - 1)) / columns
            Column(verticalArrangement = Arrangement.spacedBy(spacing)) {
                highlights.chunked(columns).forEach { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(spacing),
                    ) {
                        rowItems.forEach { highlight ->
                            HighlightCard(highlight = highlight, modifier = Modifier.width(itemWidth))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun HighlightCard(highlight: FeatureHighlight, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f),
        ),
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
            Text(
                text = stringResource(highlight.title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(highlight.text),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
