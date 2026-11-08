package de.ktdevelopment.beatcoach.web.features.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.pages__features__sections__title
import de.ktdevelopment.beatcoach.web.features.model.FeatureSection
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.deviceSize
import org.jetbrains.compose.resources.stringResource

@Composable
fun FeaturesGrid(
    sections: List<FeatureSection>,
    modifier: Modifier = Modifier,
) {
    val columns = when (deviceSize()) {
        DeviceSize.Smartphone -> 1
        DeviceSize.Tablet -> 2
        DeviceSize.Desktop, DeviceSize.LargeDesktop -> 3
    }
    val spacing = 16.dp

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(Res.string.pages__features__sections__title),
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(20.dp))
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
            val itemWidth = if (columns == 1) {
                maxWidth
            } else {
                (maxWidth - spacing * (columns - 1)) / columns
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(spacing),
            ) {
                sections.chunked(columns).forEach { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(spacing),
                    ) {
                        rowItems.forEach { section ->
                            FeatureSectionCard(
                                section = section,
                                modifier = Modifier.width(itemWidth),
                            )
                        }
                    }
                }
            }
        }
    }
}
