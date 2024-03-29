package com.jocelinoafonsofernandes.splayer.ui.theme.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.data.entities.Music
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.MusicContainer
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.callbacks.MusicContainerCallback
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.MusicViewModel.events.MusicEvents
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.MusicViewModel.state.MusicState

@Composable
fun Home(
    state: MusicState,
    onEvent: (MusicEvents) -> Unit
) {

    val isInPreview = LocalInspectionMode.current
    Column(
        Modifier
            .fillMaxSize()
            .background(costumeTheme().primaryContainer)
            .padding(horizontal = 5.dp)
    ) {
        Text(
            text = stringResource(id = R.string.all_songs),
            style = MaterialTheme.typography.headlineSmall,
            color = costumeTheme().textBold,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        if (state.isMusicLoading) {
            CircularProgressIndicator(
                color = costumeTheme().primary
            )
        }
        LazyColumn(
            Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (isInPreview) {
                true -> {
                    items(10) {
                        MusicContainer(
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

                else -> {
                    items(state.musics.size) {
                        val music = state.musics[it]
                        MusicContainer(
                            music = music,
                            callback = MusicContainerCallback(
                                onPlay = {},
                                onPause = {},
                            )
                        )
                    }
                }
            }

        }


    }

}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview() {
    Home(
        state = MusicState(),
        onEvent = {}
    )
}