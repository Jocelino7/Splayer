package com.jocelinoafonsofernandes.splayer.ui.theme.components.MusicContainer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PauseCircle
import androidx.compose.material.icons.rounded.SkipNext
import androidx.compose.material.icons.rounded.SkipPrevious
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.ui.theme.components.CostumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.components.MusicContainer.callbacks.MusicContainerCallback
import com.jocelinoafonsofernandes.splayer.ui.theme.components.UnknownAlbum

@Composable
fun MusicPlayingContainer(
    music: Music,
    callback: MusicContainerCallback
) {
    Card(
        Modifier.padding(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = CostumeTheme().primaryContainer
        )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .heightIn(max = 80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            music.albumCover?.let {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = stringResource(id = R.string.album_cover),
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Fit
                )
            } ?: UnknownAlbum()

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
                    color = CostumeTheme().textBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = music.artist,
                    fontWeight = FontWeight.Bold,
                    color = CostumeTheme().textBold
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
                    onClick = callback.onSkipPrev,
                    enabled = false
                ) {
                    Icon(
                        imageVector = Icons.Rounded.SkipPrevious,
                        contentDescription = stringResource(id = R.string.music_action),
                        tint = CostumeTheme().textBold
                    )
                }
                IconButton(onClick = callback.onPause) {
                    Icon(
                        imageVector = Icons.Rounded.PauseCircle,
                        contentDescription = stringResource(id = R.string.music_action),
                        tint = CostumeTheme().primary
                    )

                }
                IconButton(onClick = callback.onSkipNext) {
                    Icon(
                        imageVector = Icons.Rounded.SkipNext,
                        contentDescription = stringResource(id = R.string.more_option),
                        tint = CostumeTheme().textBold
                    )
                }
            }


        }

    }

}

@Preview
@Composable
fun MusicPlayingContainerPreview() {
    MusicPlayingContainer(
        music = Music(
            title = "Just Like You",
            artist = "NF",
            duration = "3:20"
        ),
        callback = MusicContainerCallback(
            onPause = {},
            onSkipPrev = {},
            onPlay = {}
        )
    )

}