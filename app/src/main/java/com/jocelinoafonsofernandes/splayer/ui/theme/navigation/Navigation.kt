package com.jocelinoafonsofernandes.splayer.ui.theme.navigation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jocelinoafonsofernandes.splayer.data.entities.Music
import com.jocelinoafonsofernandes.splayer.data.callbacks.NavigationCallBack
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.MusicPlayingContainer
import com.jocelinoafonsofernandes.splayer.ui.theme.components.musicContainer.callbacks.MusicContainerCallback
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.navigationModules.mainNavigationRoute
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.navigationModules.playlistNavigation
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.ModulesRoutes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
    navController: NavHostController,
    navigationCallBack: NavigationCallBack
) {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val sheetState = rememberModalBottomSheetState()
    LaunchedEffect(key1 = scaffoldState.bottomSheetState) {
        sheetState.show()
    }

    Scaffold(
        topBar = { },
        bottomBar = {
            Column {
                MusicPlayingContainer(
                    music = Music(
                        title = "titlulo",
                        artist = "Artidt",
                    ),
                    callback = MusicContainerCallback()
                )
                BottomBar(navController = navController)
            }

        },

        ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = ModulesRoutes.MainNavigationModule().route,

            ) {
            mainNavigationRoute(
                showBottomNav = navigationCallBack.showBottomNavBar,
                viewModelHolder = navigationCallBack.viewModelHodler!!
            )
            playlistNavigation(hideBottomBar = navigationCallBack.hideBottomNavBar)
        }

    }


}

@Preview(name = "Navigation")
@Preview(
    name = "Navigation",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    device = Devices.PIXEL_3_XL
)
@Composable
fun NavigationPreview() {
    Navigation(
        navController = rememberNavController(),
        navigationCallBack = NavigationCallBack(
            hideBottomNavBar = {},
            showBottomNavBar = {},
            showBottomNavigation = true
        )
    )
}