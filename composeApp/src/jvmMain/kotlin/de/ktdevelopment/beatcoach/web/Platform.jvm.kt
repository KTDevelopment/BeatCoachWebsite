package de.ktdevelopment.beatcoach.web

import de.ktdevelopment.beatcoach.web.skeleton.AppDestination

actual object Platform {
    actual val baseUrl: String
        get() = ""
    actual val startRoute: AppDestination
        get() = AppDestination.Home
}
