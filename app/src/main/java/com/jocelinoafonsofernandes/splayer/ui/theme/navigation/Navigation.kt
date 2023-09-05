package com.jocelinoafonsofernandes.splayer.ui.theme.navigation

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jocelinoafonsofernandes.splayer.data.entities.Music
import com.jocelinoafonsofernandes.splayer.ui.theme.components.NowPlaying
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.MusicPlayingContainer
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.callbacks.MusicContainerCallback
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.navigationModules.mainNavigationRoute
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.navigationModules.playlistNavigation
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.ModulesRoutes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
    navController: NavHostController,
) {
    val sheetState = rememberModalBottomSheetState()
    var showSheet by rememberSaveable {
        mutableStateOf(true)

    }
    //LaunchedEffect(key1 = showSheet) {
    //  showSheet = true
    //}
    Scaffold(
        topBar = { },
        bottomBar = { BottomBar(navController = navController) }
    ) { paddingValues ->
        if (showSheet) {
            ModalBottomSheet(
                onDismissRequest = { /*TODO*/ },
                content = {
                    if (sheetState.hasPartiallyExpandedState) {
                        MusicPlayingContainer(music = Music(), callback = MusicContainerCallback())
                    } else {
                        NowPlaying()
                    }
                },
                sheetState = sheetState,
                dragHandle = {}
            )

        }

        NavHost(
            navController = navController,
            startDestination = ModulesRoutes.MainNavigationModule().route,
            modifier = Modifier.padding(paddingValues)
        ) {
            mainNavigationRoute()
            playlistNavigation()
        }
    }


}

@Preview(name = "Navigation")
@Preview(
    name = "Navigation",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun NavigationPreview() {
    Navigation(navController = rememberNavController())
}