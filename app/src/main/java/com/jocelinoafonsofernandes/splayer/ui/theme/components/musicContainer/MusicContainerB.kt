package com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.data.entities.DropdownMenuItems
import com.jocelinoafonsofernandes.splayer.data.entities.Music
import com.jocelinoafonsofernandes.splayer.ui.theme.components.DropDown
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.callbacks.MusicContainerCallback
import com.jocelinoafonsofernandes.splayer.ui.theme.components.UnknownElement

@Composable
fun MusicContainerB(
    music: Music,
    callback: MusicContainerCallback
) {
    var menuExpand by remember {
        mutableStateOf(false)
    }
    var menuOffset by remember {
        mutableStateOf(Offset(0f, 0f))
    }
    Card(
        Modifier.padding(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = costumeTheme().primaryContainer,
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .heightIn(max = 60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "01",
                modifier = Modifier.padding(horizontal = 2.dp),
                color = costumeTheme().textBold,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            music.albumCover?.let {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = stringResource(id = R.string.album_cover),
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Fit
                )
            } ?: UnknownElement(
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(50.dp)
            )

            Column(
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = music.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = costumeTheme().textBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = music.duration,
                    fontWeight = FontWeight.Bold,
                    color = costumeTheme().textBold
                )
            }
            IconButton(onClick = { menuExpand = !menuExpand }) {
                Icon(
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = stringResource(id = R.string.more_option),
                    tint = costumeTheme().textBold
                )
            }
            DropDown(
                expanded = menuExpand,
                onDismiss = { menuExpand = !menuExpand },
                items = listOf(
                    DropdownMenuItems(
                        title = stringResource(id = R.string.playlist_add),
                        leadingIcon = Icons.Default.PlaylistAdd,
                        onClick = {}

                    ),
                    DropdownMenuItems(
                        title = stringResource(id = R.string.call_song),
                        leadingIcon = Icons.Default.PlaylistAdd,
                        onClick = {}

                    )
                )
            )


        }

    }

}

@Preview(showSystemUi = true)
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MusicContainerBPreview() {
    MusicContainerB(
        music = Music(
            title = "The Search",
            artist = "NF",
            albumCover = null,
            duration = "5:30"
        ),
        callback = MusicContainerCallback(
            onPause = {},
            onPlay = {},
            onSkipNext = {},
            onSkipPrev = {},
            onMoreButtonClick = {}
        )
    )
}