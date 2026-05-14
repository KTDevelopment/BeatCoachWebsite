package de.ktdevelopment.beatcoach.web

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.app_title
import beatcoachwebsite.composeapp.generated.resources.beatcoach_wortmarke_lila
import beatcoachwebsite.composeapp.generated.resources.pages__blog__label
import beatcoachwebsite.composeapp.generated.resources.pages__features__label
import beatcoachwebsite.composeapp.generated.resources.pages__home__android__button__label
import beatcoachwebsite.composeapp.generated.resources.pages__home__hero__header
import beatcoachwebsite.composeapp.generated.resources.pages__home__hero__text
import beatcoachwebsite.composeapp.generated.resources.pages__home__ios__button__label
import beatcoachwebsite.composeapp.generated.resources.pages__home__label
import de.ktdevelopment.beatcoach.web.blog.BlogScreen
import de.ktdevelopment.beatcoach.web.contact.ContactScreen
import de.ktdevelopment.beatcoach.web.features.FeaturesScreen
import de.ktdevelopment.beatcoach.web.home.HomeScreen
import de.ktdevelopment.beatcoach.web.legal.impressum.ImpressumScreen
import de.ktdevelopment.beatcoach.web.legal.privacy.PrivacyScreen
import de.ktdevelopment.beatcoach.web.skeleton.AppDestination
import de.ktdevelopment.beatcoach.web.skeleton.MainScaffold
import de.ktdevelopment.beatcoach.web.theme.BeatCoachTheme
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import kotlin.time.Duration.Companion.milliseconds

val LocalNavController =
    compositionLocalOf<NavHostController> { error("No NavController found!") }


@Composable
fun App(
    onLaunch: suspend (NavHostController) -> Unit,
) {
    val navController = rememberNavController()

    var isVisible by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(100.milliseconds)
        isVisible = false
    }

    BeatCoachTheme {
        Box {
            CompositionLocalProvider(LocalNavController provides navController) {
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
                    LaunchedEffect(navController) {
                        onLaunch(navController)
                    }
                }
            }

            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(),
                exit = fadeOut(animationSpec = tween(durationMillis = 800)),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        modifier = Modifier.width(338.dp),
                        imageVector = vectorResource(Res.drawable.beatcoach_wortmarke_lila),
                        contentDescription = stringResource(Res.string.app_title),
                    )
                }
            }
        }
    }
}

