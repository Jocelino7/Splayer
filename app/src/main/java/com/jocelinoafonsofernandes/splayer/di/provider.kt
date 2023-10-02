package com.jocelinoafonsofernandes.splayer.di

import com.jocelinoafonsofernandes.splayer.data.repository.AlbumRepository
import com.jocelinoafonsofernandes.splayer.data.repository.ArtistRepository
import com.jocelinoafonsofernandes.splayer.data.repository.MusicRepository
import com.jocelinoafonsofernandes.splayer.data.repository.PlaylistRepository
import com.jocelinoafonsofernandes.splayer.data.repository.interfaces.IAlbumRepository
import com.jocelinoafonsofernandes.splayer.data.repository.interfaces.IArtistRepository
import com.jocelinoafonsofernandes.splayer.data.repository.interfaces.IMusicRepository
import com.jocelinoafonsofernandes.splayer.data.repository.interfaces.PlaylistDAo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class InterfacesProvider {

    @Binds
    abstract fun bindsIAlbumRepository(
        albumRepository: AlbumRepository
    ): IAlbumRepository

    @Binds
    abstract fun bindsIArtistRepository(
        artistRepository: ArtistRepository
    ): IArtistRepository

    @Binds
    abstract fun bindsIMusicRepository(
        musicRepository: MusicRepository
    ): IMusicRepository

    @Binds
    abstract fun bindsIPlaylistRepository(
        playlistRepository: PlaylistRepository
    ): PlaylistDAo

}