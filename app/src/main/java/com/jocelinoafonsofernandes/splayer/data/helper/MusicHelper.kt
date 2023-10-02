package com.jocelinoafonsofernandes.splayer.data.helper

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.jocelinoafonsofernandes.splayer.data.entities.Music
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class MusicHelper @Inject constructor(

) {
    fun getSongsInAlbum(context: Context, albumId: Long): List<Music> {
        val contentResolver: ContentResolver = context.contentResolver
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.DURATION
        )

        val selection = "${MediaStore.Audio.Media.ALBUM_ID} = ?"
        val selectionArgs = arrayOf(albumId.toString())
        val sortOrder = MediaStore.Audio.Media.TITLE + " ASC"

        val cursor: Cursor? =
            contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
        val musics: MutableList<Music> = mutableListOf()

        if (cursor != null) {
            val titleColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)
            val artistColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)
            val pathColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Media.DATA)
            val durationColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)


            while (cursor.moveToNext()) {
                val duration = cursor.getLong(durationColumnIndex)
                val durationFormat = SimpleDateFormat("mm:ss", Locale.getDefault())
                val formattedDuration = durationFormat.format(Date(duration))
                val albumArtUri = Uri.parse("content://media/external/audio/albumart")
                val albumArtUriWithAlbumId = ContentUris.withAppendedId(albumArtUri, albumId)
                val songPath = cursor.getString(pathColumnIndex)
                musics.add(
                    Music(
                        title = cursor.getString(titleColumnIndex),
                        artist = cursor.getString(artistColumnIndex),
                        albumCover = albumArtUriWithAlbumId,
                        duration = formattedDuration,
                        albumId = albumId,
                        albumArtUriWithAlbumId = albumArtUriWithAlbumId,
                        musicPath = Uri.parse("file://$songPath")
                    )
                )
            }
            cursor.close()
            return musics
        }
        return musics
    }

     fun calculateAlbumDuration(context: Context, albumId: Long): String {
        val contentResolver: ContentResolver = context.contentResolver
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            "SUM(${MediaStore.Audio.Media.DURATION}) AS ${MediaStore.Audio.Media.DURATION}"
        )
        val selection = "${MediaStore.Audio.Media.ALBUM_ID} = ?"
        val selectionArgs = arrayOf(albumId.toString())

        val cursor: Cursor? = contentResolver.query(uri, projection, selection, selectionArgs, null)

        if (cursor != null) {
            val durationColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)
            if (cursor.moveToFirst()) {
                val totalDuration = cursor.getLong(durationColumnIndex)
                val durationFormat = SimpleDateFormat("mm:ss", Locale.getDefault())
                return durationFormat.format(Date(totalDuration))
            }
            cursor.close()
        }

        return "00:00"
    }
}