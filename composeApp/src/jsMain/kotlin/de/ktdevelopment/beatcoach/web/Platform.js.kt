package de.ktdevelopment.beatcoach.web

import de.ktdevelopment.beatcoach.web.skeleton.AppDestination
import kotlinx.browser.window

actual object Platform {
    actual val baseUrl: String
        get() = window.location.origin
    actual val startRoute: AppDestination
        get() {
            val hash = window.location.hash
            return when (hash.removePrefix("#")) {
                "features" -> AppDestination.Features
                else -> AppDestination.Home
            }
        }
}
