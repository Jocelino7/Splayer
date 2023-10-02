package com.jocelinoafonsofernandes.splayer.ui.theme.screens.album

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.data.entities.Music
import com.jocelinoafonsofernandes.splayer.ui.theme.components.isInPreview
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.MusicContainer
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.callbacks.MusicContainerCallback
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.local_components.AlbumContainer
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.local_components.AlbumOptions
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.albumViewModel.AlbumEvents
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.albumViewModel.AlbumState

@Composable
fun AlbumScreen(
    state: AlbumState,
    onEvent: (AlbumEvents) -> Unit
) {
    val isInPreview = isInPreview()
    val albumForPreviewMode = Album(
        title = "Mansion",
        artist = "NF",
        year = "2016",
    )
    LaunchedEffect(state.albums) {
        onEvent(AlbumEvents.GetAllAlbums)
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(costumeTheme().primaryContainer)
    ) {
        when (isInPreview) {
            true -> {
                AlbumContainer(
                    album = albumForPreviewMode
                )
                AlbumOptions(
                    album = albumForPreviewMode
                )
            }
            else -> {
                AlbumContainer(
                    album = state.sharedAlbumParameter
                )
                AlbumOptions(
                    album = state.sharedAlbumParameter
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isInPreview) {
                items(10) {
                    MusicContainer(
                        music = Music(),
                        callback = MusicContainerCallback()
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                }

            } else {
                items(state.sharedAlbumParameter.tracks.size) { index ->
                    val music = state.sharedAlbumParameter.tracks[index]
                    MusicContainer(
                        music = music,
                        callback = MusicContainerCallback()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }

            }

        }
    }
}


@Preview(
    name = "Album",
    device = Devices.PIXEL_3,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Composable
fun AlbumPreview() {
    AlbumScreen(
        state = AlbumState(),
        onEvent = {}
    )
}