package de.ktdevelopment.beatcoach.web.features.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.ktdevelopment.beatcoach.web.features.model.FeatureSection
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.deviceSize

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

    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
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
