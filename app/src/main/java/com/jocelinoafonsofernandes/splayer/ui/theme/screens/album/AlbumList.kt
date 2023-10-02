package com.jocelinoafonsofernandes.splayer.ui.theme.screens.album


import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.ui.theme.components.isInPreview
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.local_components.AlbumCard
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.albumViewModel.AlbumEvents
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.albumViewModel.AlbumState

data class AlbumCallback(
    val onAlbumCardListener: () -> Unit
)

@Composable
fun AlbumList(
    onEvent: (AlbumEvents) -> Unit,
    state: AlbumState,
    navController: NavController
) {
    val isInPreview = isInPreview()
    DisposableEffect(true) {
        onEvent(AlbumEvents.GetAllAlbums)
        onDispose { }
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(costumeTheme().primaryContainer)
            .padding(horizontal = 5.dp)
    ) {
        Text(
            text = stringResource(id = R.string.albums),
            style = MaterialTheme.typography.headlineSmall,
            color = costumeTheme().textBold,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isInPreview) {
                items(10) {
                    AlbumCard(
                        album = Album(title = "The search", artist = "NF"),
                        callback = AlbumCallback {

                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            } else {
                items(state.albums.size) {
                    val album = state.albums[it]
                    AlbumCard(
                        album = album,
                        callback = AlbumCallback {
                            onEvent(AlbumEvents.UpdateSharedAlbumParameter(album))
                            onEvent(AlbumEvents.NavigateToAlbumScreen(navController))
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }

            }

        }

    }

}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview()
@Composable
fun AlbumsPreview() {
    AlbumList(
        onEvent = {},
        state = AlbumState(),
        navController = rememberNavController()
    )
}