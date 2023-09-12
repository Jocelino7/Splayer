package com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.PauseCircle
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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
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
fun MusicContainer(
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
            music.albumCover?.let {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = stringResource(id = R.string.album_cover),
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(80.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Fit
                )
            } ?: UnknownElement()

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
                    text = music.artist,
                    fontWeight = FontWeight.Bold,
                    color = costumeTheme().textBold
                )
            }
            Row(
                Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                IconButton(
                    onClick = { /*TODO*/ },
                    enabled = false
                ) {
                    Text(
                        text = music.duration,
                        textAlign = TextAlign.Center,
                        color = costumeTheme().textBold
                    )
                }
                IconButton(onClick = callback.onPause) {
                    Icon(
                        imageVector = Icons.Rounded.PauseCircle,
                        contentDescription = stringResource(id = R.string.music_action),
                        tint = costumeTheme().primary
                    )

                }
                IconButton(
                    onClick = { menuExpand = !menuExpand },
                    modifier = Modifier.onGloballyPositioned { coordinate ->
                        menuOffset = coordinate.parentLayoutCoordinates?.positionInWindow()!!
                    }
                ) {
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

}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun MusicContainerPreview() {
    MusicContainer(
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
