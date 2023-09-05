package com.jocelinoafonsofernandes.splayer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class CostumeTheme(
    val primary: Color,
    val secondary: Color,
    val textBold: Color,
    val textBoldReverse:Color,
    val lightWeightText: Color,
    val primaryContainer: Color,
    val primaryContainerReverse: Color
)

@Composable
fun costumeTheme(): CostumeTheme {
    if (isSystemInDarkTheme()) {
        return CostumeTheme(
            primary = PrimaryColor,
            secondary = SecondaryDark,
            textBold = BoldTextDark,
            lightWeightText = LightWeightTextDark,
            primaryContainer = PrimaryContainerDark,
            primaryContainerReverse = PrimaryContainerReverseDark,
            textBoldReverse = BoldTextReverseDark
        )
    }
    return CostumeTheme(
        primary = PrimaryColor,
        secondary = SecondaryLight,
        textBold = BoldTextLight,
        lightWeightText = LightWeightTextLight,
        primaryContainer = PrimaryContainerLight,
        primaryContainerReverse = PrimaryContainerReverseLight,
        textBoldReverse = BoldTextReverseLight
    )
}