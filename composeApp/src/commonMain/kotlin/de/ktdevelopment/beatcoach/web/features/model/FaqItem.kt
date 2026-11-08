package de.ktdevelopment.beatcoach.web.features.model

import org.jetbrains.compose.resources.StringResource

data class FaqItem(
    val question: StringResource,
    val answer: StringResource,
)
