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
import beatcoachwebsite.composeapp.generated.resources.pages__features__how__step_1__text
import beatcoachwebsite.composeapp.generated.resources.pages__features__how__step_1__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__how__step_2__text
import beatcoachwebsite.composeapp.generated.resources.pages__features__how__step_2__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__how__step_3__text
import beatcoachwebsite.composeapp.generated.resources.pages__features__how__step_3__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__how__title
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.deviceSize
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

private data class HowStep(val title: StringResource, val text: StringResource)

@Composable
fun HowItWorks(modifier: Modifier = Modifier) {
    val steps = listOf(
        HowStep(Res.string.pages__features__how__step_1__title, Res.string.pages__features__how__step_1__text),
        HowStep(Res.string.pages__features__how__step_2__title, Res.string.pages__features__how__step_2__text),
        HowStep(Res.string.pages__features__how__step_3__title, Res.string.pages__features__how__step_3__text),
    )
    val columns = if (deviceSize() == DeviceSize.Smartphone) 1 else 3
    val spacing = 16.dp

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(Res.string.pages__features__how__title),
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(20.dp))
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            val itemWidth = if (columns == 1) maxWidth else (maxWidth - spacing * (columns - 1)) / columns
            Column(verticalArrangement = Arrangement.spacedBy(spacing)) {
                steps.chunked(columns).forEach { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(spacing),
                    ) {
                        rowItems.forEach { step ->
                            HowStepCard(step = step, modifier = Modifier.width(itemWidth))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun HowStepCard(step: HowStep, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        ),
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
            Text(
                text = stringResource(step.title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(step.text),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
