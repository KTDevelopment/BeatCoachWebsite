@file:OptIn(ExperimentalMaterial3Api::class)

package de.ktdevelopment.beatcoach.web.skeleton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.navigation.NavHostController

val LocalSnackbarHostState = compositionLocalOf<SnackbarHostState> {
    error("No Snackbar Host State")
}

@Composable
fun MainScaffold(
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }

    CompositionLocalProvider(
        values = arrayOf(
            LocalSnackbarHostState provides snackbarHostState
        )
    ) {
        Scaffold(
            topBar = { Header(navController) },
            bottomBar = { Footer(navController) },
            snackbarHost = {
                SnackbarHost(snackbarHostState) { data ->
                    Snackbar(
                        snackbarData = data,
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                        contentColor = MaterialTheme.colorScheme.contentColorFor(MaterialTheme.colorScheme.surfaceContainerHighest),
                        actionColor = MaterialTheme.colorScheme.primary,
                    )
                }
            },
        ) { paddingValues ->
            Box(
                modifier = Modifier.padding(
                    start = paddingValues.calculateStartPadding(LocalLayoutDirection.current),
                    top = max(paddingValues.calculateTopPadding(), 50.dp),
                    end = paddingValues.calculateEndPadding(LocalLayoutDirection.current),
                    bottom = max(paddingValues.calculateBottomPadding(), 0.dp),
                )
            ) {
                content()
            }
        }
    }
}

