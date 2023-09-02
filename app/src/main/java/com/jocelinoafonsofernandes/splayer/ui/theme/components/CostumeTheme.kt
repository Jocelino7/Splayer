package com.jocelinoafonsofernandes.splayer.ui.theme.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.jocelinoafonsofernandes.splayer.ui.theme.BoldTextDark
import com.jocelinoafonsofernandes.splayer.ui.theme.BoldTextLight
import com.jocelinoafonsofernandes.splayer.ui.theme.BoldTextReverseDark
import com.jocelinoafonsofernandes.splayer.ui.theme.BoldTextReverseLight
import com.jocelinoafonsofernandes.splayer.ui.theme.LightWeightTextDark
import com.jocelinoafonsofernandes.splayer.ui.theme.LightWeightTextLight
import com.jocelinoafonsofernandes.splayer.ui.theme.PrimaryColor
import com.jocelinoafonsofernandes.splayer.ui.theme.PrimaryContainerDark
import com.jocelinoafonsofernandes.splayer.ui.theme.PrimaryContainerLight
import com.jocelinoafonsofernandes.splayer.ui.theme.PrimaryContainerReverseDark
import com.jocelinoafonsofernandes.splayer.ui.theme.PrimaryContainerReverseLight
import com.jocelinoafonsofernandes.splayer.ui.theme.SecondaryDark
import com.jocelinoafonsofernandes.splayer.ui.theme.SecondaryLight

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
fun CostumeTheme(): CostumeTheme {
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