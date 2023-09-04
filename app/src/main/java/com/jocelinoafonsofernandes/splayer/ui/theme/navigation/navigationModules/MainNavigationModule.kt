package com.jocelinoafonsofernandes.splayer.ui.theme.navigation.navigationModules

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jocelinoafonsofernandes.splayer.data.entities.Album
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.MainRoutes
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.ModulesRoutes
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.Artist
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.album.AlbumScreen
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.home.Home
import com.jocelinoafonsofernandes.splayer.ui.theme.screens.playlist.PlayList


fun NavGraphBuilder.mainNavigationRoute() {
    this.navigation(
        route = ModulesRoutes.MainNavigationModule().route,
        startDestination = MainRoutes.Home().route
    ) {
        composable(
            route = MainRoutes.Home().route,
        ) {
            Home()
        }
        composable(
            route = MainRoutes.Album().route,
        ) {
            AlbumScreen(Album())
        }
        composable(
            route = MainRoutes.Artist().route,
        ) {
            Artist()
        }
        composable(
            route = MainRoutes.Artist().route,
        ) {
            PlayList()
        }
    }
}