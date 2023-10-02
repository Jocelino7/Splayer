package com.jocelinoafonsofernandes.splayer.ui.theme.navigation.navigationModules

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jocelinoafonsofernandes.splayer.data.entities.ViewModelHoder
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.MainRoutes
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.ModulesRoutes
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.AlbumList
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.artists.localComponents.Artists
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.home.Home
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.playlist.PlayList


fun NavGraphBuilder.mainNavigationRoute(
    showBottomNav: () -> Unit,
    viewModelHolder: ViewModelHoder,
    navController: NavController
) {
    showBottomNav()
    this.navigation(
        route = ModulesRoutes.MainNavigationModule().route,
        startDestination = MainRoutes.Home().route,
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
            AlbumList(
                state = viewModelHolder.albumViewModel.state,
                onEvent = viewModelHolder.albumViewModel::onEvent,
                navController = navController
            )
        }

        composable(
            route = MainRoutes.Artist().route,
        ) {
            Artists(
                state = viewModelHolder.artistViewModel.state,
                onEvent = viewModelHolder.artistViewModel::onEvent,
                navController = navController
            )
        }
        composable(
            route = MainRoutes.Playlist().route,
        ) {
            PlayList()
        }
    }
}