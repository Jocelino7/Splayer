package com.jocelinoafonsofernandes.splayer.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.R

@Composable
fun UnknownAlbum(modifier: Modifier=Modifier) {
    Box(
        modifier = modifier
            .width(100.dp)
            .fillMaxHeight()
            .background(color = CostumeTheme().primaryContainerReverse),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Rounded.MusicNote,
            contentDescription = stringResource(id = R.string.unknown_album),
            tint = CostumeTheme().textBoldReverse,
        )
    }
}