package com.jocelinoafonsofernandes.splayer.data.repository.interfaces

import com.jocelinoafonsofernandes.splayer.data.entities.Playlist

interface IPlayListRepository {
    fun getAllPlayList(): List<Playlist>
    fun getPlayListById(playlist: Playlist): Playlist
    fun addPlaylist(playlist: Playlist): Boolean
    fun addMusicToPlaylist(music: Playlist): Boolean
    fun deletePlaylist(playlist: Playlist): Boolean
    fun updatePlayList(playlist: Playlist): Boolean

}