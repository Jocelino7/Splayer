package com.jocelinoafonsofernandes.splayer.data.entities

import android.net.Uri

data class Artist(
    val artistId: Long = 0,
    val artistName: String = "",
    val artistKey: String = "",
    val artistArtUri: Uri?=null,
    val albumsUri: Uri?=null,
    val albums: MutableList<Album> = mutableListOf(),
)

