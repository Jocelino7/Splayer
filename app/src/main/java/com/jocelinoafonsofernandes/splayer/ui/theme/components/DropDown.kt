package com.jocelinoafonsofernandes.splayer.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jocelinoafonsofernandes.splayer.data.entities.DropdownMenuItems
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme

@Composable
fun DropDown(
    expanded: Boolean,
    onDismiss: () -> Unit,
    items: List<DropdownMenuItems>
) {
    Box {
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { onDismiss() },
            modifier = Modifier.background(costumeTheme().primaryContainer)
        ) {
            items.forEach { menu ->
                DropdownMenuItem(
                    text = { Text(menu.title, color = costumeTheme().textBold) },
                    leadingIcon = {
                        Icon(
                            imageVector = menu.leadingIcon,
                            contentDescription = null,
                            tint = costumeTheme().primary
                        )
                    },
                    onClick = { menu.onClick() }
                )
            }

        }


    }


}