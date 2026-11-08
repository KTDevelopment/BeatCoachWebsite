package de.ktdevelopment.beatcoach.web.features.model

import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource

enum class FeatureTag {
    ORGANIZE,
    PRACTICE,
    PLAYBACK,
    SETUP,
}

data class FeatureSection(
    val id: String,
    val icon: ImageVector,
    val title: StringResource,
    val benefit: StringResource,
    val bullets: List<StringResource>,
    val details: List<StringResource> = emptyList(),
    val tags: Set<FeatureTag> = emptySet(),
)
