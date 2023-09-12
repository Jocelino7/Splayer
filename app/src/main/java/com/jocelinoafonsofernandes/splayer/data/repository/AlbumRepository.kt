package com.jocelinoafonsofernandes.splayer.data.repository

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.data.helper.MusicHelper
import com.jocelinoafonsofernandes.splayer.data.repository.interfaces.IAlbumRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AlbumRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val musicHelper: MusicHelper
) : IAlbumRepository {
    override suspend fun getAllAlbum(): List<Album> {
        val contentResolver: ContentResolver = context.contentResolver
        val uri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Albums._ID,
            MediaStore.Audio.Albums.ALBUM,
            MediaStore.Audio.Albums.ARTIST,
            MediaStore.Audio.Albums.ALBUM_ART,
            MediaStore.Audio.Albums.NUMBER_OF_SONGS,
            MediaStore.Audio.Albums.FIRST_YEAR
        )

        val sortOrder = MediaStore.Audio.Albums.ALBUM + " ASC"

        val cursor: Cursor? = contentResolver.query(uri, projection, null, null, sortOrder)
        val albums: MutableList<Album> = mutableListOf()

        if (cursor != null) {

            val idColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Albums._ID)
            val albumNameColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM)
            val artistColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Albums.ARTIST)
            val albumArtColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART)
            val numSongsColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Albums.NUMBER_OF_SONGS)
            val yearColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Albums.FIRST_YEAR)
            val albumId = cursor.getLong(idColumnIndex)

            while (cursor.moveToNext()) {
                albums.add(
                    Album(
                        albumId = albumId,
                        title = cursor.getString(albumNameColumnIndex),
                        artist = cursor.getString(artistColumnIndex),
                        year = cursor.getString(yearColumnIndex),
                        numSongs = cursor.getInt(numSongsColumnIndex),
                        albumDuration = musicHelper.calculateAlbumDuration(context, albumId),
                        albumCover = cursor.getString(albumArtColumnIndex)?.let { Uri.parse(it) },
                        tracks = musicHelper.getSongsInAlbum(
                            context = context,
                            albumId = albumId
                        )
                    )
                )

            }
            cursor.close()
            return albums
        }
        return albums
    }

}
