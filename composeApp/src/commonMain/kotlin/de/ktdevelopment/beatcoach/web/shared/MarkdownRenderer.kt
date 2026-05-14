package de.ktdevelopment.beatcoach.web.shared

import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.Res
import com.mikepenz.markdown.m3.Markdown
import com.mikepenz.markdown.model.markdownPadding

@Composable
fun MarkdownRenderer(markdownFilePath: String, errorText: String = "") {
    val languageCode = Locale.current.language
    var markdownText by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(true) }
    LaunchedEffect(languageCode) {
        try {
            val bytes = Res.readBytes("files/$languageCode/${markdownFilePath}")
            markdownText = bytes.decodeToString()
        } catch (_: Exception) {
            markdownText = Res.readBytes("files/en/${markdownFilePath}").decodeToString()
        }
        loading = false
    }

    if (markdownText.isNotEmpty()) {
        Markdown(
            modifier = Modifier.widthIn(max = 800.dp),
            content = markdownText,
            padding = markdownPadding(
                block = 16.dp,   // Abstand zwischen allen Top-Level Blöcken
                list = 4.dp      // Abstand innerhalb von Listen
            ),
        )
    } else if (!loading) {
        Text(text = errorText)
    }
}
