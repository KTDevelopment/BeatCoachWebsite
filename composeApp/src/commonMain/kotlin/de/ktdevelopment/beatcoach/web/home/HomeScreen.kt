package de.ktdevelopment.beatcoach.web.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.ktdevelopment.beatcoach.web.skeleton.PageContainer


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomeScreen() {
    PageContainer {
        Column {
            HeroContent()
            Spacer(modifier = Modifier.height(128.dp))
        }
    }
}

