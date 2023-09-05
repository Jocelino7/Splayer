package com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlaylistPlay
import androidx.compose.material.icons.outlined.Album
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PlaylistPlay
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MainRoutes(
    val route:String,
    val selectedIcon:ImageVector,
    val unselectedIcon:ImageVector
){
    class Home():MainRoutes(
        route = "Music",
        selectedIcon = Icons.Outlined.MusicNote,
        unselectedIcon = Icons.Filled.MusicNote
    )
    class Album():MainRoutes(
        route = "Album",
        selectedIcon = Icons.Outlined.Album,
        unselectedIcon = Icons.Filled.Album
    )
    class Artist():MainRoutes(
        route = "Artist",
        selectedIcon = Icons.Outlined.Person,
        unselectedIcon = Icons.Filled.Person
    )
    class Playlist():MainRoutes(
        route = "PlayList",
        selectedIcon = Icons.Outlined.PlaylistPlay,
        unselectedIcon = Icons.Filled.PlaylistPlay
    )

}
