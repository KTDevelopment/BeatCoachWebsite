package de.ktdevelopment

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToBrowserNavigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import de.ktdevelopment.beatcoach.theme.BeatCoachTheme
import de.ktdevelopment.blog.BlogScreen
import de.ktdevelopment.contact.ContactScreen
import de.ktdevelopment.features.FeaturesScreen
import de.ktdevelopment.home.HomeScreen
import de.ktdevelopment.legal.impressum.ImpressumScreen
import de.ktdevelopment.legal.privacy.PrivacyScreen
import de.ktdevelopment.skeleton.AppDestination
import de.ktdevelopment.skeleton.MainScaffold

@OptIn(ExperimentalBrowserHistoryApi::class)
@Composable
fun App() {
    val navController = rememberNavController()

    LaunchedEffect(navController) {
        navController.bindToBrowserNavigation()
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
                    HomeScreen(navigate = {
                        navController.navigate(AppDestination.Features)
                    })
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
