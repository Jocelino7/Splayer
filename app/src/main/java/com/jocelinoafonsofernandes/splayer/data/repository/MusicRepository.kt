package com.jocelinoafonsofernandes.splayer.data.repository

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.jocelinoafonsofernandes.splayer.data.entities.Music
import com.jocelinoafonsofernandes.splayer.data.repository.interfaces.IMusicRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class MusicRepository @Inject constructor(
    @ApplicationContext private val context: Context
) : IMusicRepository {
    override suspend fun getAllMusic(): List<Music> {
        val contentResolver: ContentResolver = context.contentResolver
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.ALBUM_ID,
            MediaStore.Audio.Media.DURATION
        )

        val sortOrder = MediaStore.Audio.Media.TITLE + " ASC"

        val cursor: Cursor? = contentResolver.query(uri, projection, null, null, sortOrder)
        val musics: MutableList<Music> = mutableListOf()

        if (cursor != null) {
            val titleColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)
            val artistColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)
            val albumIdColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)
            val durationColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)
            val pathColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Media.DATA)

            while (cursor.moveToNext()) {
                val songPath = cursor.getString(pathColumnIndex)
                val duration = cursor.getLong(durationColumnIndex)
                val durationFormat = SimpleDateFormat("mm:ss", Locale.getDefault())
                val formattedDuration = durationFormat.format(Date(duration))
                val albumCover = Uri.parse("content://media/external/audio/albumart")
                val albumId = cursor.getLong(albumIdColumnIndex)


                musics.add(
                    Music(
                        albumId = albumId,
                        title = cursor.getString(titleColumnIndex),
                        artist = cursor.getString(artistColumnIndex),
                        albumCover = albumCover,
                        albumArtUriWithAlbumId = ContentUris.withAppendedId(albumCover, albumId),
                        duration = formattedDuration,
                        musicPath = Uri.parse("file://$songPath")
                    )
                )
            }
            cursor.close()
        }
        return musics
    }
}