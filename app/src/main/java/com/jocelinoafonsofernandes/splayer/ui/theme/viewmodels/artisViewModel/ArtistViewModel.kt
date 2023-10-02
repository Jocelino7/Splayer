package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.artisViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.data.entities.Artist
import com.jocelinoafonsofernandes.splayer.data.provider.SharedParameterProvider
import com.jocelinoafonsofernandes.splayer.data.repository.ArtistRepository
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.AlbumRoute
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.artisViewModel.events.ArtistEvents
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.artisViewModel.state.ArtistState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ArtistViewModel @Inject constructor(
    private val artistRepository: ArtistRepository,
    private val sharedParameterProvider: SharedParameterProvider
) : ViewModel() {
    var state by mutableStateOf(ArtistState())

    fun onEvent(event: ArtistEvents) {
        when (event) {
            is ArtistEvents.getAllArtist -> getAllArtist()
            is ArtistEvents.UpdateArtistParameter -> updateArtistParameter(event.album)
            is ArtistEvents.UpdateSharedAlbumParameter -> updateSharedAlbumParameter(event.album)
            is ArtistEvents.NavigateToAlbum -> navigateToAlbumScreen(event.navController)
        }
    }

    private fun navigateToAlbumScreen(
        navController: NavController
    ) {
        navController.navigate(AlbumRoute.ArtistAlbum().route)

    }

    private fun getAllArtist() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                state =
                    state.copy(artist = artistRepository.getAllArtists(), isArtisLoading = false)
            }
        }
    }

    private fun updateArtistParameter(
        artist: Artist
    ) {
        state = state.copy(artistParameter = artist)
    }

    private fun updateSharedAlbumParameter(
        artist: Album
    ) {
        sharedParameterProvider.updateSharedParameter(
            parameter = sharedParameterProvider.sharedParameter.copy(albumParameter = artist)
        )
    }


}