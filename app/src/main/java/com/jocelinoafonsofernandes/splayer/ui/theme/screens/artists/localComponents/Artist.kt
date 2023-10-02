package com.jocelinoafonsofernandes.splayer.ui.theme.screens.artists.localComponents


import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.data.callbacks.ArtistCallback
import com.jocelinoafonsofernandes.splayer.data.entities.Artist
import com.jocelinoafonsofernandes.splayer.ui.theme.components.isInPreview
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.artisViewModel.events.ArtistEvents
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.artisViewModel.state.ArtistState


@Composable
fun Artists(
    state: ArtistState,
    onEvent: (ArtistEvents) -> Unit,
    navController: NavController
) {
    val isInPreview = isInPreview()
    if (state.isArtisLoading) {
        CircularProgressIndicator(color = costumeTheme().primary)
    }
    LaunchedEffect(state.artist) {
        onEvent(ArtistEvents.getAllArtist)
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(costumeTheme().primaryContainer)
            .padding(horizontal = 5.dp)
    ) {
        Text(
            text = stringResource(id = R.string.artists),
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
                    ArtistContainer(
                        Artist(artistName = "NF"),
                        artistCallback = ArtistCallback { }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider(
                        thickness = 1.dp
                    )
                }
            } else {
                items(state.artist.size) { index ->
                    val artist = state.artist[index]
                    ArtistContainer(
                        artist = artist,
                        artistCallback = ArtistCallback(
                            onArtistCardClick = {
                                onEvent(ArtistEvents.UpdateArtistParameter(artist))
                                onEvent(ArtistEvents.NavigateToAlbum(navController = navController))
                            }
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider(
                        thickness = 1.dp
                    )
                }


            }

        }

    }

}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview()
@Composable
fun AlbumsPreview() {
    Artists(
        state = ArtistState(),
        onEvent = {},
        navController = rememberNavController()
    )
}