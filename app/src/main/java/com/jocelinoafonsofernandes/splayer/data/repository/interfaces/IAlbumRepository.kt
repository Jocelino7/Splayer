package com.jocelinoafonsofernandes.splayer.data.repository.interfaces

import android.content.Context
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.data.entities.Music

interface IAlbumRepository {


    suspend fun getAllAlbum(): List<Album>

}