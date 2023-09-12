package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.playlistViewModel.events

import com.jocelinoafonsofernandes.splayer.data.entities.Music

sealed class PlaylistEvents {
    object navigateToPlaylistScreen : PlaylistEvents()
    object navigateToPlaylist : PlaylistEvents()
    data class onPlaylistTextFieldChange(
        val text: String
    ) : PlaylistEvents()

    object showPlayListCreationModal : PlaylistEvents()
    data class removeMusicFromPlayList(
        val music: Music,
    ):PlaylistEvents()

    data class addMusicToPlayList(val music: Music):PlaylistEvents()
    object updatePlaylistName:PlaylistEvents()
}
