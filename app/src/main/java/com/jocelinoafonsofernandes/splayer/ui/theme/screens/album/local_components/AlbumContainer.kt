package com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.local_components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.ui.theme.components.UnknownElement
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme


@Composable
fun AlbumContainer(album: Album) {
    val isInPreview = LocalInspectionMode.current
    Row(
        Modifier
            .fillMaxWidth()
            .background(
                color = Color.White
            )
            .heightIn(min = 200.dp, max = 300.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isInPreview) {
            UnknownElement(modifier = Modifier.size(100.dp))
        } else {
            AsyncImage(
                model = album.albumCover,
                contentDescription = stringResource(id = R.string.album_cover),
                modifier = Modifier
                    .size(100.dp)
                    .padding(start = 10.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Fit
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column(
            Modifier.height(100.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = album.title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = costumeTheme().textBold
            )
            Text(
                text = album.artist,
                color = costumeTheme().textBold,
            )
            Text(
                text = album.year,
                color = costumeTheme().textBold,
            )

        }
    }
}

@Preview
@Composable
fun AlbumContainerPreview() {
    AlbumContainer(album = Album())

}