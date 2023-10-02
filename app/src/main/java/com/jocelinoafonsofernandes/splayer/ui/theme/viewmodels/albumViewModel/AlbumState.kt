package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.albumViewModel

import com.jocelinoafonsofernandes.splayer.data.entities.Album

data class AlbumState(
    val albums: List<Album> = emptyList(),
    val isAlbumsLoading: Boolean = true,
    val albumParameter:Album?=null,
    val sharedAlbumParameter:Album=Album()
)
