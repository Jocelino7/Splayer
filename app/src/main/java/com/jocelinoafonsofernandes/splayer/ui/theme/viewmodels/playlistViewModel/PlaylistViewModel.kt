package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.playlistViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jocelinoafonsofernandes.splayer.data.entities.Playlist
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.playlistViewModel.state.PlaylistState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlaylistViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(PlaylistState())

    fun onEvent(Play)

    fun getAllPlayList(){

    }

    fun getPlayListById(id: Int){}

    fun addPlaylist(playlist: Playlist){}

    fun deletePlaylist(playlist: Playlist){}

    fun updatePlayList(playlist: Playlist){}

}