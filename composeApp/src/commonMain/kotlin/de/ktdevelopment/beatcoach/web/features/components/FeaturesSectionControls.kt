package de.ktdevelopment.beatcoach.web.features.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.*
import de.ktdevelopment.beatcoach.web.features.model.FeatureTag
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import org.jetbrains.compose.resources.stringResource

@Composable
fun FeaturesSectionControls(
    selectedTags: Set<FeatureTag>,
    onToggleTag: (FeatureTag) -> Unit,
    onClearTags: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val filters = listOf(
        FeatureTag.ORGANIZE to Res.string.pages__features__filter__organize,
        FeatureTag.PRACTICE to Res.string.pages__features__filter__practice,
        FeatureTag.PLAYBACK to Res.string.pages__features__filter__playback,
        FeatureTag.SETUP to Res.string.pages__features__filter__setup,
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            FilterChip(
                selected = selectedTags.isEmpty(),
                onClick = onClearTags,
                label = { Text(stringResource(Res.string.pages__features__filter__all)) },
                modifier = Modifier.cursorHand(),
            )
            filters.forEach { (tag, label) ->
                FilterChip(
                    selected = tag in selectedTags,
                    onClick = { onToggleTag(tag) },
                    label = { Text(stringResource(label)) },
                    modifier = Modifier.cursorHand(),
                )
            }
        }
    }
}
