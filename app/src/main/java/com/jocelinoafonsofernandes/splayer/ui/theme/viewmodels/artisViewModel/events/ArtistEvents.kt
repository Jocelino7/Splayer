package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.artisViewModel.events

import androidx.navigation.NavController
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.data.entities.Artist

sealed class ArtistEvents {
    object getAllArtist : ArtistEvents()
    data class UpdateArtistParameter(
        val album: Artist
    ) : ArtistEvents()

    data class UpdateSharedAlbumParameter(val album: Album)  : ArtistEvents()
    data class NavigateToAlbum(val navController: NavController)  : ArtistEvents()
}