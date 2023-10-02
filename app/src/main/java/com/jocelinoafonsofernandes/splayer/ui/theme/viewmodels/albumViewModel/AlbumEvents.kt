package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.albumViewModel

import androidx.navigation.NavController
import com.jocelinoafonsofernandes.splayer.data.entities.Album

sealed class AlbumEvents {
    object GetAllAlbums : AlbumEvents()
    data class UpdateAlbumParameter(val album:Album) : AlbumEvents()
    data class UpdateSharedAlbumParameter(val album:Album) : AlbumEvents()
    data class NavigateToAlbumScreen(val navController: NavController) : AlbumEvents()
}

