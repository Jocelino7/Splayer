package com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.local_components


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.data.enum.UnknownEnum
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.components.UnknownElement
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.AlbumCallback


@Composable
fun AlbumCard(
    album: Album,
    callback: AlbumCallback
) {
    var menuExpand by remember {
        mutableStateOf(false)
    }
    var menuOffset by remember {
        mutableStateOf(Offset(0f, 0f))
    }
    Card(
        Modifier.padding(2.dp)
            .clickable {
                callback.onAlbumCardListener()
            },
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
                .heightIn(min = 60.dp, max = 80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            album.albumCover?.let { uri ->
                AsyncImage(
                    model = uri,
                    contentDescription = stringResource(id = R.string.album_cover),
                    modifier = Modifier
                        .fillMaxHeight()
                        .widthIn(max = 60.dp)
                        .clip(CircleShape)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Fit
                )
            } ?: UnknownElement(
                Modifier
                    .fillMaxHeight()
                    .widthIn(max = 80.dp)
                    .border(
                        width = 2.dp,
                        shape = CircleShape,
                        color = costumeTheme().primary
                    )
                    .clip(CircleShape)
                    .aspectRatio(1f),
                unknownEnum = UnknownEnum.UnknownAlbum
            )

            Column(
                Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = album.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = costumeTheme().textBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = album.artist,
                    fontWeight = FontWeight.Bold,
                    color = costumeTheme().textBold
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
fun AlbumCardPreview() {
    AlbumCard(
        album = Album(
            title = "The Search",
            artist = "NF",
            albumCover = null,
        ),
        callback = AlbumCallback(
            onAlbumCardListener = {}

        )
    )
}
