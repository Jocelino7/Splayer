package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.MusicViewModel.state

import com.jocelinoafonsofernandes.splayer.data.entities.Music

data class MusicState(
    val musics: List<Music> = emptyList(),
    val isMusicLoading: Boolean = true
)