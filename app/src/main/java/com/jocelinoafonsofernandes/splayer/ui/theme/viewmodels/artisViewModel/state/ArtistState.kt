package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.artisViewModel.state

import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.data.entities.Artist

data class ArtistState(
    val artist: List<Artist> = emptyList(),
    val isArtisLoading: Boolean = true,
    val artistParameter: Artist? = null,
    val albumPreviewParameter:Album = Album(
        artist = "Nf",
        title = "Leave me alone"
    )
)
