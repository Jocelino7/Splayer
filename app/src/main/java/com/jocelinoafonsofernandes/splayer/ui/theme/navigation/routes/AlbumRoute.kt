package com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.outlined.Album
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AlbumRoute(
    val route:String,
    val selectedIcon: ImageVector?=null,
    val unselectedIcon: ImageVector?=null
){
    class AlbumScreen:AlbumRoute("AlbumScreen"){
    }
    class ArtistAlbum:AlbumRoute("ArtistAlbum"){
    }
}
