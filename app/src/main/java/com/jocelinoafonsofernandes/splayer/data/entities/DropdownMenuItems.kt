package com.jocelinoafonsofernandes.splayer.data.entities

import androidx.compose.ui.graphics.vector.ImageVector

data class DropdownMenuItems(
    val title: String,
    val leadingIcon: ImageVector,
    val onClick: () -> Unit
)
