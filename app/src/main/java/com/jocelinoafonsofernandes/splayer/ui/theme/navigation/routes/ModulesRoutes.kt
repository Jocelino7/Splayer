package com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes

sealed class ModulesRoutes(val route:String){
    class MainNavigationModule:ModulesRoutes("MainNavigationModule")
    class PlaylistNavigationModule:ModulesRoutes("PlaylistNavigationModule")

}
