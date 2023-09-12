package com.jocelinoafonsofernandes.splayer.data.repository

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.data.entities.Artist
import com.jocelinoafonsofernandes.splayer.data.helper.MusicHelper
import com.jocelinoafonsofernandes.splayer.data.repository.interfaces.IArtistRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ArtistRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val musicHelper: MusicHelper
) : IArtistRepository {
    override suspend fun getAllArtists(): List<Artist> {
        val contentResolver: ContentResolver = context.contentResolver
        val artistsUri = MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Artists._ID,
            MediaStore.Audio.Artists.ARTIST,
            MediaStore.Audio.Artists.ARTIST_KEY
        )

        val sortOrder = MediaStore.Audio.Artists.ARTIST + " ASC"

        val artists: MutableList<Artist> = mutableListOf()

        val artistsCursor: Cursor? =
            contentResolver.query(artistsUri, projection, null, null, sortOrder)

        artistsCursor?.use { cursor ->
            val idColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Artists._ID)
            val artistNameColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST)
            val artistKeyColumnIndex = cursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST_KEY)

            while (cursor.moveToNext()) {
                val artistId = cursor.getLong(idColumnIndex)
                val artistName = cursor.getString(artistNameColumnIndex)
                val artistKey = cursor.getString(artistKeyColumnIndex)
                val artistArtUri = Uri.parse("content://media/external/audio/artists/$artistKey")

                val albums: MutableList<Album> = mutableListOf()

                val albumsUri = MediaStore.Audio.Artists.Albums.getContentUri("external", artistId)
                val albumsProjection = arrayOf(
                    MediaStore.Audio.Albums._ID,
                    MediaStore.Audio.Albums.ALBUM,
                    MediaStore.Audio.Albums.ALBUM_ART,
                    MediaStore.Audio.Albums.NUMBER_OF_SONGS,
                    MediaStore.Audio.Albums.FIRST_YEAR
                )

                val albumsCursor: Cursor? =
                    contentResolver.query(albumsUri, albumsProjection, null, null, null)

                albumsCursor?.use { albumCursor ->
                    val albumIdColumnIndex = albumCursor.getColumnIndex(MediaStore.Audio.Albums._ID)
                    val albumNameColumnIndex =
                        albumCursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM)
                    val albumArtColumnIndex =
                        albumCursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART)
                    val numSongsColumnIndex =
                        albumCursor.getColumnIndex(MediaStore.Audio.Albums.NUMBER_OF_SONGS)
                    val yearColumnIndex =
                        albumCursor.getColumnIndex(MediaStore.Audio.Albums.FIRST_YEAR)

                    while (albumCursor.moveToNext()) {
                        val albumId = albumCursor.getLong(albumIdColumnIndex)
                        albums.add(
                            Album(
                                albumId = albumId,
                                title = albumCursor.getString(albumNameColumnIndex),
                                artist = artistName,
                                year = albumCursor.getString(yearColumnIndex),
                                tracks = musicHelper.getSongsInAlbum(context, albumId),
                                albumDuration = musicHelper.calculateAlbumDuration(
                                    context,
                                    albumId
                                ),
                                albumCover = albumCursor.getString(albumArtColumnIndex)
                                    ?.let { Uri.parse(it) },
                                numSongs = albumCursor.getInt(numSongsColumnIndex),
                            )
                        )
                    }
                }

                artists.add(
                    Artist(
                        artistId = artistId,
                        artistName = artistName,
                        artistKey = artistKey,
                        artistArtUri = artistArtUri,
                        albumsUri = albumsUri,
                        albums = albums
                    )
                )
            }
        }

        return artists
    }

}