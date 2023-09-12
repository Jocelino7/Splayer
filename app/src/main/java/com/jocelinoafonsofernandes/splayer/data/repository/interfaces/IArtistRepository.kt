package com.jocelinoafonsofernandes.splayer.data.repository.interfaces

import com.jocelinoafonsofernandes.splayer.data.entities.Artist

interface IArtistRepository {
   suspend fun getAllArtists():List<Artist>
}