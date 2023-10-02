package com.jocelinoafonsofernandes.splayer.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Album
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.data.enum.UnknownEnum
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme

@Composable
fun UnknownElement(
    modifier: Modifier = Modifier,
    unknownEnum: UnknownEnum = UnknownEnum.UnknownMusic
) {
    val icon = when (unknownEnum) {
        UnknownEnum.UnknownAlbum -> Icons.Rounded.Album
        UnknownEnum.UnknownArtist -> Icons.Rounded.Person
        UnknownEnum.UnknownMusic -> Icons.Rounded.MusicNote
    }
    Box(
        modifier = modifier
            .width(50.dp)
            .fillMaxHeight()
            .heightIn(max=100.dp)
            .background(color = costumeTheme().primaryContainerReverse),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = stringResource(id = R.string.unknown_album),
            tint = costumeTheme().textBoldReverse,
        )
    }
}

@Preview
@Composable
fun UnknownPreview() {
    UnknownElement()
}