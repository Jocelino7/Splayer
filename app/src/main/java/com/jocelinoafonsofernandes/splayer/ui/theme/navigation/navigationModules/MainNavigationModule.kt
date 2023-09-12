package com.jocelinoafonsofernandes.splayer.ui.theme.navigation.navigationModules

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jocelinoafonsofernandes.splayer.data.entities.ViewModelHoder
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.MainRoutes
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.ModulesRoutes
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.Albums
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.artists.localComponents.Artists
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.home.Home
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.playlist.PlayList


fun NavGraphBuilder.mainNavigationRoute(
    showBottomNav: () -> Unit,
    viewModelHolder: ViewModelHoder
) {
    showBottomNav()
    this.navigation(
        route = ModulesRoutes.MainNavigationModule().route,
        startDestination = MainRoutes.Home().route
    ) {
        composable(
            route = MainRoutes.Home().route,
        ) {
            Home(
                state = viewModelHolder.musicViewModel.state,
                onEvent = viewModelHolder.musicViewModel::onEvent
            )
        }
        composable(
            route = MainRoutes.Album().route,
        ) {
            Albums()
        }
        composable(
            route = MainRoutes.Artist().route,
        ) {
            Artists()
        }
        composable(
            route = MainRoutes.Playlist().route,
        ) {
            PlayList()
        }
    }
}