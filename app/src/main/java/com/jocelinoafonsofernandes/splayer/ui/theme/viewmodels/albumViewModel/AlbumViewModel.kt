package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.albumViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.data.provider.SharedParameterProvider
import com.jocelinoafonsofernandes.splayer.data.repository.AlbumRepository
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.AlbumRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val albumRepository: AlbumRepository,
    val sharedAlbumProvider: SharedParameterProvider
) : ViewModel() {
    var state by mutableStateOf(AlbumState())

    private fun getAllAlbums() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                state = state.copy(
                    albums = albumRepository.getAllAlbum(),
                    isAlbumsLoading = false
                )
            }
        }
    }

    fun onEvent(event: AlbumEvents) {
        when (event) {
            is AlbumEvents.GetAllAlbums -> getAllAlbums()
            is AlbumEvents.UpdateAlbumParameter -> state = state.copy(albumParameter = event.album)
            is AlbumEvents.UpdateSharedAlbumParameter -> updateSharedAlbumParameter(event.album)
            is AlbumEvents.NavigateToAlbumScreen -> event.navController.navigate(
                AlbumRoute.AlbumScreen().route
            )
        }
    }

    private fun updateSharedAlbumParameter(album: Album) {
        state = state.copy(sharedAlbumParameter = album)

    }
}