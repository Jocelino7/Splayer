package com.jocelinoafonsofernandes.splayer.data.global

sealed class SharedEvents {
    data class SetReadExternalStoragePermissionState(
        val value: Boolean
    ) : SharedEvents()
}
