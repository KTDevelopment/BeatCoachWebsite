package de.ktdevelopment.theme

import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon


fun Modifier.cursorHand(): Modifier = this.pointerHoverIcon(PointerIcon.Hand)
