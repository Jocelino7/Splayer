package com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes

sealed class PlaylistRoutes(val route:String){
    class PlaylistsDetails:PlaylistRoutes("PlaylistsDetails")
    class Playlist:PlaylistRoutes("Playlist")
}