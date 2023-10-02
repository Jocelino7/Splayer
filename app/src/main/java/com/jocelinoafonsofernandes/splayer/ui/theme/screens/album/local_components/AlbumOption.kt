package com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.local_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.RepeatOne
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme


@Composable
fun AlbumOptions(album: Album) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(costumeTheme().primaryContainer)
    ) {
        Text(
            text = "${album.tracks.size} ${stringResource(id = R.string.tracks)}-${album.albumDuration}",
            fontWeight = FontWeight.Bold,
            color = costumeTheme().textBold
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Repeat,
                contentDescription = stringResource(id = R.string.repeat),
                tint = costumeTheme().primaryContainer
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.RepeatOne,
                contentDescription = stringResource(id = R.string.repeat),
                tint = costumeTheme().primaryContainer
            )
        }


    }

}