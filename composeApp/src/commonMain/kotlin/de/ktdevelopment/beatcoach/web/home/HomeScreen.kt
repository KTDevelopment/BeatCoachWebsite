package de.ktdevelopment.beatcoach.web.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(navigate: () -> Unit) {
    Column {
        Text("Home")
        Button(onClick = navigate) {
            Text("to Features")
        }

        Box(modifier = Modifier.height(1000.dp).width(20.dp).background(Color.Red))
        Text("Bottom")
    }

}
