package com.jocelinoafonsofernandes.splayer.data.repository

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.jocelinoafonsofernandes.splayer.data.database.AppDataBase
import com.jocelinoafonsofernandes.splayer.data.entities.Playlist
import com.jocelinoafonsofernandes.splayer.data.repository.interfaces.PlaylistDAo
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PlaylistRepository @Inject constructor(
    @ApplicationContext private val context: Context
) : PlaylistDAo {
    companion object {
        val databaseName = "playlistDatabase"
    }

    private val database = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        databaseName
    ).build()

    override fun getAllPlayList(): List<Playlist> {
        return database.playListDao().getAllPlayList()
    }

    override fun getPlayListById(id: Int): Playlist {
        return database.playListDao().getPlayListById(id)
    }

    override fun addPlaylist(playlist: Playlist): Boolean {
        return try {
            database.playListDao().addPlaylist(playlist)
            true
        } catch (e: Exception) {
            e.message?.let {
                Log.d("AddPlayListException", it)

            }
            false
        }
    }

    override fun deletePlaylist(playlist: Playlist): Boolean {
        return try {
            database.playListDao().deletePlaylist(playlist)
            true
        } catch (e: Exception) {
            e.message?.let {
                Log.d("AddPlayListException", it)
            }
            false
        }
    }

    override fun updatePlayList(playlist: Playlist): Boolean {
        return try {
            database.playListDao().updatePlayList(playlist)
            true
        } catch (e: Exception) {
            e.message?.let {
                Log.d("AddPlayListException", it)
            }
            false
        }
    }
}