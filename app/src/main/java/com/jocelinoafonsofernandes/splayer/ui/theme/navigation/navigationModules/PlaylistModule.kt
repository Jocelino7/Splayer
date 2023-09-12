package com.jocelinoafonsofernandes.splayer.ui.theme.navigation.navigationModules

import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.PlaylistRoutes
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.playlist.PlaylistsScreen


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.ModulesRoutes
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.playlist.PlayList


fun NavGraphBuilder.playlistNavigation(hideBottomBar: () -> Unit) {
    hideBottomBar()
    this.navigation(
        route = ModulesRoutes.PlaylistNavigationModule().route,
        startDestination = PlaylistRoutes.PlaylistsDetails().route,
    ) {
        composable(
            route = PlaylistRoutes.PlaylistsDetails().route,
        ) {
            PlaylistsScreen()
        }
        composable(
            route = PlaylistRoutes.Playlist().route,
        ) {
            PlayList()
        }

    }
}