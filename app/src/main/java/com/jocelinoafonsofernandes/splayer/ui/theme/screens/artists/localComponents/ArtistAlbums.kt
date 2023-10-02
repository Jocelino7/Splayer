package com.jocelinoafonsofernandes.splayer.ui.theme.screens.artists.localComponents

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.ui.theme.components.isInPreview
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.AlbumCallback
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.local_components.AlbumCard
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.artisViewModel.events.ArtistEvents
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.artisViewModel.state.ArtistState

@Composable
fun ArtistAlbums(
    state: ArtistState,
    onEvent: (ArtistEvents) -> Unit,
    navController: NavController
) {
    val isInPreview = isInPreview()
    Column(
        Modifier
            .fillMaxSize()
            .background(costumeTheme().primaryContainer)
            .padding(5.dp)
    ) {
        Text(
            text = "${stringResource(id = R.string.from)} ${state.artistParameter!!.artistName}" ,
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
                        album = state.albumPreviewParameter,
                        callback = AlbumCallback { }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            } else {
                items(state.artistParameter!!.albums.size) {
                    val album = state.artistParameter.albums[it]
                    AlbumCard(
                        album = album,
                        callback = AlbumCallback(
                            onAlbumCardListener = {
                                onEvent(
                                    ArtistEvents.UpdateSharedAlbumParameter(
                                        album
                                    )
                                )
                                onEvent(
                                    ArtistEvents.NavigateToAlbum(
                                        navController = navController
                                    )
                                )
                            }
                        )
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
fun ArtistAlbumsPreview() {
    ArtistAlbums(
        state = ArtistState(),
        onEvent = {},
        navController = rememberNavController()
    )
}