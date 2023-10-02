package com.jocelinoafonsofernandes.splayer.data.repository.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jocelinoafonsofernandes.splayer.data.entities.Playlist

@Dao
interface PlaylistDAo {
    @Query("SELECT * FROM playlist")
    fun getAllPlayList(): List<Playlist>
    @Query("SELECT * FROM playlist WHERE id IN (:id)")
    fun getPlayListById(id: Int): Playlist
    @Insert
    fun addPlaylist(playlist: Playlist): Boolean
    @Delete
    fun deletePlaylist(playlist: Playlist): Boolean
    @Update
    fun updatePlayList(playlist: Playlist): Boolean

}