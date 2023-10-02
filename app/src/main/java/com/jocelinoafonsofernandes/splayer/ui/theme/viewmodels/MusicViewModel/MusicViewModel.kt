package com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.MusicViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jocelinoafonsofernandes.splayer.data.entities.Music
import com.jocelinoafonsofernandes.splayer.data.repository.interfaces.IMusicRepository
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.MusicViewModel.events.MusicEvents
import com.jocelinoafonsofernandes.splayer.ui.theme.viewmodels.MusicViewModel.state.MusicState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val musicRepository: IMusicRepository
) : ViewModel() {
    var state by mutableStateOf(MusicState())



    fun getAllMusic() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val musics = musicRepository.getAllMusic()
                withContext(Dispatchers.Main) {
                    state = state.copy(
                        musics = musics,
                        isMusicLoading = false
                    )
                }
            }
        }


    }

    fun onEvent(event: MusicEvents) {
        when (event) {
            is MusicEvents.getAllMusic -> getAllMusic()

        }

    }

}