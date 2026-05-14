@file:OptIn(ExperimentalMaterial3Api::class)

package de.ktdevelopment.beatcoach.web.skeleton

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.navigation.NavHostController
import de.ktdevelopment.beatcoach.web.skeleton.header.Header
import de.ktdevelopment.beatcoach.web.skeleton.header.NavigationDrawerContent
import de.ktdevelopment.beatcoach.web.theme.DeviceSize
import de.ktdevelopment.beatcoach.web.theme.deviceSize
import de.ktdevelopment.beatcoach.web.theme.horizontalPagePadding
import kotlinx.coroutines.launch

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
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        ModalNavigationDrawer(
            drawerContent = {
                NavigationDrawerContent(navController) {
                    scope.launch { drawerState.close() }
                }
            },
            drawerState = drawerState,
            gesturesEnabled = deviceSize() === DeviceSize.Smartphone,
        ) {
            Scaffold(
                topBar = {
                    Header(openMobileDrawer = {
                        scope.launch { drawerState.open() }
                    })
                },
                bottomBar = { },
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
                    LazyColumn(
                        modifier = Modifier
                            .padding(start = horizontalPagePadding(), end = horizontalPagePadding())
                            .fillMaxSize()
                    ) {
                        item {
                            content()
                        }
                    }
                }
            }
        }
    }
}

