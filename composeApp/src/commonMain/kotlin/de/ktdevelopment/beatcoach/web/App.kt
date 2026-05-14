package de.ktdevelopment.beatcoach.web

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import de.ktdevelopment.beatcoach.theme.BeatCoachTheme
import de.ktdevelopment.beatcoach.web.blog.BlogScreen
import de.ktdevelopment.beatcoach.web.contact.ContactScreen
import de.ktdevelopment.beatcoach.web.features.FeaturesScreen
import de.ktdevelopment.beatcoach.web.home.HomeScreen
import de.ktdevelopment.beatcoach.web.legal.impressum.ImpressumScreen
import de.ktdevelopment.beatcoach.web.legal.privacy.PrivacyScreen
import de.ktdevelopment.beatcoach.web.skeleton.AppDestination
import de.ktdevelopment.beatcoach.web.skeleton.MainScaffold

@Composable
fun App(
    onLaunch: suspend (NavHostController) -> Unit,
) {
    val navController = rememberNavController()

    LaunchedEffect(navController) {
        onLaunch(navController)
    }
    BeatCoachTheme {
        MainScaffold(navController) {
            NavHost(
                navController = navController,
                startDestination = Platform.startRoute
            ) {
                composable<AppDestination.Home>(
                    deepLinks = listOf(navDeepLink<AppDestination.Home>(basePath = "${Platform.baseUrl}/#home"))
                ) {
                    HomeScreen()
                }
                composable<AppDestination.Features>(
                    deepLinks = listOf(navDeepLink<AppDestination.Home>(basePath = "${Platform.baseUrl}/#features"))
                ) {
                    FeaturesScreen()
                }
                composable<AppDestination.Blog>(
                    deepLinks = listOf(navDeepLink<AppDestination.Home>(basePath = "${Platform.baseUrl}/#blog"))
                ) {
                    BlogScreen()
                }
                composable<AppDestination.Contact>(
                    deepLinks = listOf(navDeepLink<AppDestination.Home>(basePath = "${Platform.baseUrl}/#contact"))
                ) {
                    ContactScreen()
                }
                composable<AppDestination.PrivacyPolicy>(
                    deepLinks = listOf(navDeepLink<AppDestination.Home>(basePath = "${Platform.baseUrl}/#privacy"))
                ) {
                    PrivacyScreen()
                }
                composable<AppDestination.Impressum>(
                    deepLinks = listOf(navDeepLink<AppDestination.Home>(basePath = "${Platform.baseUrl}/#impressum"))
                ) {
                    ImpressumScreen()
                }
            }
        }
    }
}
