package de.ktdevelopment.beatcoach.web.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.pages__features__audio__bullet_1
import beatcoachwebsite.composeapp.generated.resources.pages__features__audio__bullet_2
import beatcoachwebsite.composeapp.generated.resources.pages__features__audio__bullet_3
import beatcoachwebsite.composeapp.generated.resources.pages__features__audio__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__documents__bullet_1
import beatcoachwebsite.composeapp.generated.resources.pages__features__documents__bullet_2
import beatcoachwebsite.composeapp.generated.resources.pages__features__documents__bullet_3
import beatcoachwebsite.composeapp.generated.resources.pages__features__documents__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__exercises__bullet_1
import beatcoachwebsite.composeapp.generated.resources.pages__features__exercises__bullet_2
import beatcoachwebsite.composeapp.generated.resources.pages__features__exercises__bullet_3
import beatcoachwebsite.composeapp.generated.resources.pages__features__exercises__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__importexport__bullet_1
import beatcoachwebsite.composeapp.generated.resources.pages__features__importexport__bullet_2
import beatcoachwebsite.composeapp.generated.resources.pages__features__importexport__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__intro
import beatcoachwebsite.composeapp.generated.resources.pages__features__metronome__bullet_1
import beatcoachwebsite.composeapp.generated.resources.pages__features__metronome__bullet_2
import beatcoachwebsite.composeapp.generated.resources.pages__features__metronome__bullet_3
import beatcoachwebsite.composeapp.generated.resources.pages__features__metronome__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__midi__bullet_1
import beatcoachwebsite.composeapp.generated.resources.pages__features__midi__bullet_2
import beatcoachwebsite.composeapp.generated.resources.pages__features__midi__bullet_3
import beatcoachwebsite.composeapp.generated.resources.pages__features__midi__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__songs__bullet_1
import beatcoachwebsite.composeapp.generated.resources.pages__features__songs__bullet_2
import beatcoachwebsite.composeapp.generated.resources.pages__features__songs__bullet_3
import beatcoachwebsite.composeapp.generated.resources.pages__features__songs__title
import beatcoachwebsite.composeapp.generated.resources.pages__features__title
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.ClockSolid
import compose.icons.lineawesomeicons.CogSolid
import compose.icons.lineawesomeicons.FileAudio
import compose.icons.lineawesomeicons.FileImportSolid
import compose.icons.lineawesomeicons.FilePdfSolid
import compose.icons.lineawesomeicons.MusicSolid
import compose.icons.lineawesomeicons.SyncSolid
import de.ktdevelopment.beatcoach.web.features.components.FeaturesCta
import de.ktdevelopment.beatcoach.web.features.components.FeaturesGrid
import de.ktdevelopment.beatcoach.web.features.model.FeatureSection
import de.ktdevelopment.beatcoach.web.skeleton.PageContainer
import de.ktdevelopment.beatcoach.web.theme.horizontalPagePadding
import org.jetbrains.compose.resources.stringResource

@Composable
fun FeaturesScreen() {
    PageContainer {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPagePadding()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(Res.string.pages__features__title),
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.widthIn(max = 900.dp),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(Res.string.pages__features__intro),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.widthIn(max = 820.dp),
            )
            Spacer(modifier = Modifier.height(40.dp))

            FeaturesGrid(
                sections = featureSections(),
                modifier = Modifier.widthIn(max = 1200.dp),
            )

            Spacer(modifier = Modifier.height(48.dp))
            FeaturesCta(modifier = Modifier.widthIn(max = 820.dp))
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun featureSections(): List<FeatureSection> = listOf(
    FeatureSection(
        icon = LineAwesomeIcons.ClockSolid,
        title = Res.string.pages__features__metronome__title,
        bullets = listOf(
            Res.string.pages__features__metronome__bullet_1,
            Res.string.pages__features__metronome__bullet_2,
            Res.string.pages__features__metronome__bullet_3,
        ),
    ),
    FeatureSection(
        icon = LineAwesomeIcons.FileAudio,
        title = Res.string.pages__features__songs__title,
        bullets = listOf(
            Res.string.pages__features__songs__bullet_1,
            Res.string.pages__features__songs__bullet_2,
            Res.string.pages__features__songs__bullet_3,
        ),
    ),
    FeatureSection(
        icon = LineAwesomeIcons.MusicSolid,
        title = Res.string.pages__features__audio__title,
        bullets = listOf(
            Res.string.pages__features__audio__bullet_1,
            Res.string.pages__features__audio__bullet_2,
            Res.string.pages__features__audio__bullet_3,
        ),
    ),
    FeatureSection(
        icon = LineAwesomeIcons.FilePdfSolid,
        title = Res.string.pages__features__documents__title,
        bullets = listOf(
            Res.string.pages__features__documents__bullet_1,
            Res.string.pages__features__documents__bullet_2,
            Res.string.pages__features__documents__bullet_3,
        ),
    ),
    FeatureSection(
        icon = LineAwesomeIcons.SyncSolid,
        title = Res.string.pages__features__exercises__title,
        bullets = listOf(
            Res.string.pages__features__exercises__bullet_1,
            Res.string.pages__features__exercises__bullet_2,
            Res.string.pages__features__exercises__bullet_3,
        ),
    ),
    FeatureSection(
        icon = LineAwesomeIcons.CogSolid,
        title = Res.string.pages__features__midi__title,
        bullets = listOf(
            Res.string.pages__features__midi__bullet_1,
            Res.string.pages__features__midi__bullet_2,
            Res.string.pages__features__midi__bullet_3,
        ),
    ),
    FeatureSection(
        icon = LineAwesomeIcons.FileImportSolid,
        title = Res.string.pages__features__importexport__title,
        bullets = listOf(
            Res.string.pages__features__importexport__bullet_1,
            Res.string.pages__features__importexport__bullet_2,
        ),
    ),
)
