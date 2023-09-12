package com.jocelinoafonsofernandes.splayer.ui.theme.screens.playlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.data.entities.Music
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.callbacks.MusicContainerCallback
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.playlist.localComponents.FloatingButton
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.playlist.localComponents.PlaylistContainer


@Composable
fun PlaylistsScreen() {
    Scaffold(
        floatingActionButton = {
            FloatingButton {
            }
        },
        floatingActionButtonPosition = FabPosition.End

    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
                .background(costumeTheme().primaryContainer)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 5.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(10) {
                    PlaylistContainer(
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


}


@Preview
@Composable
fun PlaylistScreenPreview() {
    PlaylistsScreen()
}