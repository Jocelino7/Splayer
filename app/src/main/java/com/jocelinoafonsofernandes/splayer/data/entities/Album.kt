package com.jocelinoafonsofernandes.splayer.data.entities

import android.net.Uri


data class Album(
    val albumId: Long=0,
    val title: String = "",
    val artist: String = "",
    val year: String = "",
    val tracks: List<Music> = emptyList(),
    val albumDuration: String="04:20",
    val albumCover: Uri? = null,
    val numSongs:Int=0
)

