package com.jocelinoafonsofernandes.splayer.data.entities

import android.net.Uri

data class Music(
    val title: String = "",
    val artist: String = "",
    val albumCover: Uri? = null,
    val duration: String = "",
    val albumId: Long=0,
    val albumArtUriWithAlbumId: Uri? = null,
    val musicPath:Uri?=null
)

