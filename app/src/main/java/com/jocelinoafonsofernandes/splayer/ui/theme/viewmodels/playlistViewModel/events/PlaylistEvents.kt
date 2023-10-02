package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.playlistViewModel.events

import com.jocelinoafonsofernandes.splayer.data.entities.Music
import com.jocelinoafonsofernandes.splayer.data.entities.Playlist

sealed class PlaylistEvents {
    object NavigateToPlaylistScreen : PlaylistEvents()
    object NavigateToPlaylist : PlaylistEvents()
    data class OnPlaylistTextFieldChange(
        val text: String
    ) : PlaylistEvents()

    object ShowPlayListCreationModal : PlaylistEvents()
    data class RemoveMusicFromPlayList(
        val music: Music,
    ) : PlaylistEvents()

    data class AddMusicToPlayList(val music: Music) : PlaylistEvents()
    object UpdatePlaylistName : PlaylistEvents()

    object GetAllPlayList : PlaylistEvents()

    data class GetPlayListById(val id: Int) : PlaylistEvents()

    data class AddPlaylist(val playlist: Playlist) : PlaylistEvents()

    data class DeletePlaylist(val playlist: Playlist) : PlaylistEvents()

    data class UpdatePlayList(val playlist: Playlist) : PlaylistEvents()
}
