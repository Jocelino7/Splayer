package com.jocelinoafonsofernandes.splayer.ui.theme.screens.playlist.modal

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.jocelinoafonsofernandes.splayer.R
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme


@Composable
fun AddPlayListModal(
    value: String = "",
    onPlaylistTextFieldChange: (String) -> Unit
) {

    Dialog(
        onDismissRequest = { /*TODO*/ }) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = costumeTheme().primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = value,
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.name_your_playlist)
                        )
                    },
                    onValueChange = { text -> onPlaylistTextFieldChange(text) },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = costumeTheme().primaryContainer,
                        cursorColor = costumeTheme().primary,
                        focusedIndicatorColor = costumeTheme().primary,
                        unfocusedIndicatorColor = costumeTheme().primaryContainerReverse,
                        unfocusedContainerColor = costumeTheme().primaryContainer,
                        focusedTextColor = costumeTheme().textBold,
                        unfocusedTextColor = costumeTheme().textBold
                    ),
                )
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = costumeTheme().primary
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.create_playlist),
                        color = Color.White
                    )

                }

            }


        }

    }

}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Preview(
    showBackground = true
)
@Composable
fun AddPlayListModalPreview() {
    AddPlayListModal(
        onPlaylistTextFieldChange = {},
        value = "playlist"
    )
}