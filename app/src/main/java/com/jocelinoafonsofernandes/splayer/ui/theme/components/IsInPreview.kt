package com.jocelinoafonsofernandes.splayer.ui.theme.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode

@Composable
fun isInPreview(): Boolean {
    return LocalInspectionMode.current
}