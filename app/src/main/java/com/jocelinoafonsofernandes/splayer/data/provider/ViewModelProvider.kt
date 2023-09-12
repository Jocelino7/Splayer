package com.jocelinoafonsofernandes.splayer.data.provider

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jocelinoafonsofernandes.splayer.data.entities.ViewModelHoder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProvider @Inject constructor(


) {


    @Composable
    fun provideViewModels(): ViewModelHoder = ViewModelHoder(
        musicViewModel = hiltViewModel(),
        playlistViewModel = hiltViewModel()
    )

}