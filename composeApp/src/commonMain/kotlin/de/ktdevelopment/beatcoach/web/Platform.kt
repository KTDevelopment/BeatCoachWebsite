package de.ktdevelopment.beatcoach.web

import de.ktdevelopment.beatcoach.web.skeleton.AppDestination

expect object Platform {
    val baseUrl: String
    val startRoute: AppDestination
}
