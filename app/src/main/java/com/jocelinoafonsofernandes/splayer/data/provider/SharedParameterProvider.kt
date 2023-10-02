package com.jocelinoafonsofernandes.splayer.data.provider

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.jocelinoafonsofernandes.splayer.data.entities.SharedParameter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedParameterProvider @Inject constructor() {
    var sharedParameter by mutableStateOf(SharedParameter())
        private set

    fun updateSharedParameter(parameter: SharedParameter) {
        sharedParameter = parameter
    }

}