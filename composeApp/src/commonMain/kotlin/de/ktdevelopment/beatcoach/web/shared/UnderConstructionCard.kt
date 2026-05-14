package de.ktdevelopment.beatcoach.web.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.pages__home__label
import beatcoachwebsite.composeapp.generated.resources.shared__under_construction__label
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.HammerSolid
import de.ktdevelopment.beatcoach.web.LocalNavController
import de.ktdevelopment.beatcoach.web.skeleton.AppDestination
import org.jetbrains.compose.resources.stringResource

@Composable
fun UnderConstructionCard() {
    val navController = LocalNavController.current
    Card(
        modifier = Modifier.width(300.0.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Icon(LineAwesomeIcons.HammerSolid, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(Res.string.shared__under_construction__label),
                )
            }
            Button(onClick = {
                navController.navigate(AppDestination.Home)
            }) {
                Text(stringResource(Res.string.pages__home__label))
            }
            Spacer(modifier = Modifier.height(32.dp))
        }

    }
}
