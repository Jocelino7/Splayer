package com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.callbacks

data class MusicContainerCallback(
    val onPause:()->Unit={},
    val onPlay:()->Unit={},
    val onSkipNext:()->Unit={},
    val onSkipPrev:()->Unit={},
    val onMoreButtonClick:()->Unit={}
)
