package de.ktdevelopment.beatcoach.web.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun HomeScreen(navigate: () -> Unit) {
    Column {
        Text("Home")
        Button(onClick = navigate) {
            Text("to Features")
        }
    }

}
