@file:OptIn(ExperimentalSerializationApi::class)

package de.ktdevelopment.beatcoach.web

import de.ktdevelopment.beatcoach.web.skeleton.AppDestination
import kotlinx.browser.window
import kotlinx.serialization.ExperimentalSerializationApi


actual object Platform {
    actual val baseUrl: String
        get() = window.location.origin
    actual val startRoute: AppDestination
        get() {
            val hash = window.location.hash

            return when (hash.removePrefix("#")) {
                AppDestination.Features.serializer().descriptor.serialName -> AppDestination.Features
                AppDestination.Blog.serializer().descriptor.serialName -> AppDestination.Blog
                AppDestination.Contact.serializer().descriptor.serialName -> AppDestination.Contact
                AppDestination.PrivacyPolicy.serializer().descriptor.serialName -> AppDestination.PrivacyPolicy
                AppDestination.Impressum.serializer().descriptor.serialName -> AppDestination.Impressum
                else -> AppDestination.Home
            }
        }
}
