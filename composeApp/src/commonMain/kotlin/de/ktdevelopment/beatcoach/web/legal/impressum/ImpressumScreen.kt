package de.ktdevelopment.beatcoach.web.legal.impressum

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.ktdevelopment.beatcoach.web.shared.MarkdownRenderer
import de.ktdevelopment.beatcoach.web.skeleton.PageContainer


@Composable
fun ImpressumScreen() {
    PageContainer {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MarkdownRenderer("impressum.md")
        }
    }
}
