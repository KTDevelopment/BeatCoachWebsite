package de.ktdevelopment.beatcoach.web.skeleton.header

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import beatcoachwebsite.composeapp.generated.resources.Res
import beatcoachwebsite.composeapp.generated.resources.header__android_description
import beatcoachwebsite.composeapp.generated.resources.header__ios_description
import beatcoachwebsite.composeapp.generated.resources.header__youtube_description
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.Android
import compose.icons.lineawesomeicons.AppStoreIos
import compose.icons.lineawesomeicons.InfoCircleSolid
import compose.icons.lineawesomeicons.Youtube
import de.ktdevelopment.beatcoach.web.Platform
import de.ktdevelopment.beatcoach.web.theme.cursorHand
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SocialLinksRow() {
    Row {
        for (link in socialLinks) {
            IconButton(
                modifier = Modifier.cursorHand(),
                onClick = { Platform.openInternetUrl(link.url) },
            ) {
                Icon(
                    imageVector = link.icon,
                    contentDescription = stringResource(link.description),
                )
            }
        }
    }
}

@Composable
fun SocialLinksMenu() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.wrapContentSize(Alignment.TopStart)
    ) {
        IconButton(onClick = { expanded = true }) {
            Icon(
                imageVector = LineAwesomeIcons.InfoCircleSolid,
                contentDescription = "Optionen anzeigen"
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            for (link in socialLinks) {
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = link.icon,
                            contentDescription = stringResource(link.description),
                        )
                    },
                    text = {
                        Text(stringResource(link.description))
                    },
                    onClick = {
                        expanded = false
                        Platform.openInternetUrl(link.url)
                    }
                )
            }
        }
    }
}

data class SocialLink(
    val icon: ImageVector,
    val description: StringResource,
    val url: String,
)

val androidAppLink = SocialLink(
    icon = LineAwesomeIcons.Android,
    description = Res.string.header__android_description,
    url = "https://play.google.com/store/apps/details?id=de.ktdevelopment.beatcoach&pcampaignid=web_share"
)

val iosAppLink = SocialLink(
    icon = LineAwesomeIcons.AppStoreIos,
    description = Res.string.header__ios_description,
    url = "https://apps.apple.com/de/app/beatcoach/id6756516517"
)

val youtubeLink = SocialLink(
    icon = LineAwesomeIcons.Youtube,
    description = Res.string.header__youtube_description,
    url = "https://www.youtube.com/channel/UCYz2jl4Xd6Dl-blrR3Wx9Qg"
)

val socialLinks = listOf(
    androidAppLink,
    iosAppLink,
    youtubeLink,
)
