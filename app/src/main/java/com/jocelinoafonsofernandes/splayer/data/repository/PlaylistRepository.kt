package com.jocelinoafonsofernandes.splayer.data.repository

import com.jocelinoafonsofernandes.splayer.data.entities.Playlist
import com.jocelinoafonsofernandes.splayer.data.repository.interfaces.IPlayListRepository
import javax.inject.Inject

class PlaylistRepository @Inject constructor(): IPlayListRepository {
    override fun getAllPlayList(): List<Playlist> {
        TODO("Not yet implemented")
    }

    override fun getPlayListById(playlist: Playlist): Playlist {
        TODO("Not yet implemented")
    }

    override fun addPlaylist(playlist: Playlist): Boolean {
        TODO("Not yet implemented")
    }

    override fun addMusicToPlaylist(music: Playlist): Boolean {
        TODO("Not yet implemented")
    }

    override fun deletePlaylist(playlist: Playlist): Boolean {
        TODO("Not yet implemented")
    }

    override fun updatePlayList(playlist: Playlist): Boolean {
        TODO("Not yet implemented")
    }
}