package de.ktdevelopment.beatcoach.web.features.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.pages__features__details__hide
import beatcoachwebsite.composeapp.generated.resources.pages__features__details__show
import de.ktdevelopment.beatcoach.web.features.model.FeatureSection
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import org.jetbrains.compose.resources.stringResource

@Composable
fun FeatureSectionCard(
    section: FeatureSection,
    modifier: Modifier = Modifier,
) {
    var expanded by rememberSaveable(section.id) { mutableStateOf(false) }

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = section.icon,
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                    tint = MaterialTheme.colorScheme.primary,
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = stringResource(section.title),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
            Text(
                text = stringResource(section.benefit),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            section.bullets.forEach { bullet ->
                BulletRow(text = stringResource(bullet))
            }
            if (section.details.isNotEmpty()) {
                TextButton(
                    onClick = { expanded = !expanded },
                    modifier = Modifier.cursorHand(),
                ) {
                    Text(
                        text = stringResource(
                            if (expanded) Res.string.pages__features__details__hide
                            else Res.string.pages__features__details__show
                        )
                    )
                }
                AnimatedVisibility(visible = expanded) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        section.details.forEach { detail ->
                            BulletRow(
                                text = stringResource(detail),
                                muted = true,
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
private fun BulletRow(text: String, muted: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
    ) {
        Text(
            text = "•",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.width(16.dp),
            textAlign = TextAlign.Center,
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = if (muted) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(1f),
        )
    }
}
