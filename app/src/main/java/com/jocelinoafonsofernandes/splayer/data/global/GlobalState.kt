package com.jocelinoafonsofernandes.splayer.data.global

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GlobalState @Inject constructor() {
    var state by mutableStateOf(SharedState())
    fun onEvent(events: SharedEvents) {
        when (events) {
            is SharedEvents.SetReadExternalStoragePermissionState -> {
                state = state.copy(
                    hasReadExternalStoragePermission = events.value
                )
            }
        }

    }
}