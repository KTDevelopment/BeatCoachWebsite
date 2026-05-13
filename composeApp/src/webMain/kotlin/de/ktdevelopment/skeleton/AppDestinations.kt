@file:OptIn(ExperimentalUuidApi::class)

package de.ktdevelopment.skeleton

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi


@Serializable
sealed interface AppDestination {

    @Serializable
    @SerialName("home")
    data object Home: AppDestination

    @Serializable
    @SerialName("features")
    data object Features: AppDestination

    @Serializable
    @SerialName("blog")
    data object Blog: AppDestination

    @Serializable
    @SerialName("contact")
    data object Contact: AppDestination

    @Serializable
    @SerialName("privacy")
    data object PrivacyPolicy: AppDestination

    @Serializable
    @SerialName("impressum")
    data object Impressum: AppDestination
}



