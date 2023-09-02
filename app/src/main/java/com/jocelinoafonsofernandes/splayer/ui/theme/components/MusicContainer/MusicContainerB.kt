package com.jocelinoafonsofernandes.splayer.ui.theme.components.MusicContainer

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.ui.theme.components.CostumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.components.MusicContainer.callbacks.MusicContainerCallback
import com.jocelinoafonsofernandes.splayer.ui.theme.components.UnknownAlbum

@Composable
fun MusicContainerB(
    music: Music,
    callback: MusicContainerCallback
) {
    Card(
        Modifier.padding(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = CostumeTheme().primaryContainer,
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
                modifier = Modifier.padding(horizontal=2.dp),
                color = CostumeTheme().textBold,
                textAlign = TextAlign.Center,
                maxLines=1,
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
            } ?: UnknownAlbum(
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
                    color = CostumeTheme().textBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = music.duration,
                    fontWeight = FontWeight.Bold,
                    color = CostumeTheme().textBold
                )
            }
            IconButton(onClick = callback.onMoreButtonClick) {
                Icon(
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = stringResource(id = R.string.more_option),
                    tint = CostumeTheme().textBold
                )
            }


        }

    }

}

@Preview
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