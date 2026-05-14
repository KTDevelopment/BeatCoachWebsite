package de.ktdevelopment.beatcoach.web

import de.ktdevelopment.beatcoach.web.skeleton.AppDestination
import java.awt.Desktop
import java.net.URI

actual object Platform {
    actual val baseUrl: String
        get() = ""
    actual val startRoute: AppDestination
        get() = AppDestination.Home

    actual fun openInternetUrl(url: String) {
        if (Desktop.isDesktopSupported()) {
            val desktop = Desktop.getDesktop()
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(URI(url))
            }
        }
    }

    actual fun sendEmailTo(recipient: String) {
        val uriString = "mailto:$recipient"

        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(URI(uriString))
        }
    }
}
