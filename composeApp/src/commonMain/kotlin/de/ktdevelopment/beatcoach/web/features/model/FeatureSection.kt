package de.ktdevelopment.beatcoach.web.features.model

import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource

data class FeatureSection(
    val icon: ImageVector,
    val title: StringResource,
    val bullets: List<StringResource>,
)
