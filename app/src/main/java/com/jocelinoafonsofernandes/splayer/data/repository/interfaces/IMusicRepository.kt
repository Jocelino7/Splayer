package com.jocelinoafonsofernandes.splayer.data.repository.interfaces

import com.jocelinoafonsofernandes.splayer.data.entities.Music

interface IMusicRepository {
    suspend fun getAllMusic(): List<Music>

}