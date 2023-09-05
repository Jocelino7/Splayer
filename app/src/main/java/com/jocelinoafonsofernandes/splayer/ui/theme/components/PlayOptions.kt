package com.jocelinoafonsofernandes.splayer.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SkipNext
import androidx.compose.material.icons.outlined.SkipPrevious
import androidx.compose.material.icons.rounded.PauseCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme

@Composable
fun PlayOption() {
    Row(
        Modifier.widthIn(max = 150.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IconButton(
            onClick = {},
            enabled = false
        ) {
            Icon(
                imageVector = Icons.Outlined.SkipPrevious,
                contentDescription = stringResource(id = R.string.music_action),
                tint = costumeTheme().textBold,
                modifier = Modifier.size(60.dp)
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Rounded.PauseCircle,
                contentDescription = stringResource(id = R.string.music_action),
                tint = costumeTheme().primary,
                modifier = Modifier.size(60.dp)
            )

        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Outlined.SkipNext,
                contentDescription = stringResource(id = R.string.more_option),
                tint = costumeTheme().textBold,
                modifier = Modifier.size(60.dp)

            )
        }
    }

}

@Preview
@Composable
fun PlayOptionPreview() {
    PlayOption()
}