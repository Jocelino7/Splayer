package com.jocelinoafonsofernandes.splayer.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jocelinoafonsofernandes.splayer.data.entities.Playlist
import com.jocelinoafonsofernandes.splayer.data.repository.interfaces.PlaylistDAo

@Database(entities = [Playlist::class],version=1)
abstract class AppDataBase:RoomDatabase() {
    abstract  fun playListDao():PlaylistDAo
}