@file:OptIn(ExperimentalUuidApi::class)

package de.ktdevelopment.beatcoach.web.skeleton

import androidx.compose.runtime.Composable
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.pages__blog__label
import beatcoachwebsite.composeapp.generated.resources.pages__features__label
import beatcoachwebsite.composeapp.generated.resources.pages__home__label
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource
import kotlin.uuid.ExperimentalUuidApi


@Serializable
sealed interface AppDestination {

    @Serializable
    @SerialName("home")
    data object Home : AppDestination

    @Serializable
    @SerialName("features")
    data object Features : AppDestination

    @Serializable
    @SerialName("blog")
    data object Blog : AppDestination

    @Serializable
    @SerialName("contact")
    data object Contact : AppDestination

    @Serializable
    @SerialName("privacy")
    data object PrivacyPolicy : AppDestination

    @Serializable
    @SerialName("impressum")
    data object Impressum : AppDestination
}

fun AppDestination.serializer(): KSerializer<out AppDestination> = when (this) {
    AppDestination.Blog -> AppDestination.Blog.serializer()
    AppDestination.Contact -> AppDestination.Contact.serializer()
    AppDestination.Features -> AppDestination.Features.serializer()
    AppDestination.Home -> AppDestination.Home.serializer()
    AppDestination.Impressum -> AppDestination.Impressum.serializer()
    AppDestination.PrivacyPolicy -> AppDestination.PrivacyPolicy.serializer()
}

@Composable
fun AppDestination.label(): String = when (this) {
    AppDestination.Home -> stringResource(Res.string.pages__home__label)
    AppDestination.Features -> stringResource(Res.string.pages__features__label)
    AppDestination.Blog -> stringResource(Res.string.pages__blog__label)
    else -> ""
}


