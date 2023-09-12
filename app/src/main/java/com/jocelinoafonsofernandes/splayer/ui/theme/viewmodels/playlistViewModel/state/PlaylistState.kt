package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.playlistViewModel.state

import com.jocelinoafonsofernandes.splayer.data.entities.Playlist

data class PlaylistState(
    val playListTextField: String = "",
    val showCreatePlayListModal: Boolean = false,
    val sharedArgument: SharedArgument? = null
)
data class SharedArgument(
    val playList: Playlist
)
