package com.jocelinoafonsofernandes.splayer.ui.theme.screens.album

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.RepeatOne
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.ui.theme.components.CostumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.components.MusicContainer.Music
import com.jocelinoafonsofernandes.splayer.ui.theme.components.MusicContainer.MusicContainerB
import com.jocelinoafonsofernandes.splayer.ui.theme.components.MusicContainer.callbacks.MusicContainerCallback

data class Album(
    val title: String,
    val artist: String,
    val year: String,
    val tracks: Int,
    val minutes: Int
)

@Composable
fun AlbumContainer(album: Album) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(CostumeTheme().secondary)
            .heightIn(min = 200.dp, max = 300.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = stringResource(id = R.string.album_cover),
            modifier = Modifier
                .size(100.dp)
                .padding(start = 10.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Column(
            Modifier.height(100.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = album.title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = CostumeTheme().textBold
            )
            Text(
                text = album.artist,
                color = CostumeTheme().textBold,
            )
            Text(
                text = album.year,
                color = CostumeTheme().textBold,
            )

        }
    }
}

@Composable
fun AlbumOptions(album: Album) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(CostumeTheme().primaryContainer)
    ) {
        Text(
            text = "${album.tracks} ${stringResource(id = R.string.tracks)}-${album.minutes}",
            fontWeight = FontWeight.Bold
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Repeat,
                contentDescription = stringResource(id = R.string.repeat),
                tint = CostumeTheme().primaryContainer
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.RepeatOne,
                contentDescription = stringResource(id = R.string.repeat),
                tint = CostumeTheme().primaryContainer
            )
        }


    }

}

@Composable
fun AlbumScreen(album: Album) {
    Column(
        Modifier
            .fillMaxSize()
            .background(CostumeTheme().primaryContainer)
    ) {
        AlbumContainer(
            album = Album(
                title = "Mansion",
                artist = "NF",
                year = "2016",
                tracks = 10,
                minutes = 60

            )
        )
        AlbumOptions(album)
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(10) {
                MusicContainerB(
                    music = Music(
                        title = "The search",
                        artist = "NF",
                        duration = "3:30"
                    ),
                    callback = MusicContainerCallback(
                        onPlay = {},
                        onPause = {},
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }


    }

}


@Preview
@Composable
fun AlbumPreview() {
    AlbumScreen(
        album = Album(
            title = "Mansion",
            artist = "NF",
            year = "2016",
            tracks = 12,
            minutes = 120
        )
    )
}