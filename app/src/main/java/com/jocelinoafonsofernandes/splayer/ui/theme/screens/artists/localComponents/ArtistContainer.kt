package com.jocelinoafonsofernandes.splayer.ui.theme.screens.artists.localComponents


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.data.callbacks.ArtistCallback
import com.jocelinoafonsofernandes.splayer.data.entities.Artist
import com.jocelinoafonsofernandes.splayer.data.enum.UnknownEnum
import com.jocelinoafonsofernandes.splayer.ui.theme.components.UnknownElement
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme


@Composable
fun ArtistContainer(
    artist: Artist,
    artistCallback: ArtistCallback
) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                artistCallback.onArtistCardClick()
            }
            .heightIn(max = 60.dp)
            .background(costumeTheme().primaryContainer),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        artist.artistArtUri?.let {
            AsyncImage(
                model = it,
                contentDescription = stringResource(id = R.string.album_cover),
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 10.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Fit
            )
        } ?: UnknownElement(unknownEnum = UnknownEnum.UnknownArtist)

        Spacer(modifier = Modifier.padding(10.dp))
        Column(
            Modifier.height(100.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = artist.artistName,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = costumeTheme().textBold
            )
        }
    }
}

@Preview
@Composable
fun ArtistContainerPreview() {
    ArtistContainer(
        artist = Artist(
            artistName = "NF"
        ),
        artistCallback = ArtistCallback {  }
    )
}