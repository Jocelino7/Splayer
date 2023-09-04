package com.jocelinoafonsofernandes.splayer.ui.theme.screens.playlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.data.entities.Music
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.MusicContainerB
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.callbacks.MusicContainerCallback


@Composable
fun PlayList() {
    Column(
        Modifier
            .fillMaxSize()
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
fun PlayListPreview() {
    PlayList()
}