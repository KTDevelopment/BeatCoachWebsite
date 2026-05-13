package de.ktdevelopment

import de.ktdevelopment.skeleton.AppDestination

expect object Platform {
    val baseUrl: String
    val startRoute: AppDestination
}
