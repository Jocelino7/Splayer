package com.jocelinoafonsofernandes.splayer.ui.theme.navigation

import android.content.res.Configuration
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jocelinoafonsofernandes.splayer.ui.theme.costumeTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.routes.MainRoutes

@Composable
fun BottomBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val items = listOf<MainRoutes>(
        MainRoutes.Home(),
        MainRoutes.Album(),
        MainRoutes.Artist(),
        MainRoutes.Playlist()
    )
    NavigationBar(
        containerColor = costumeTheme().primaryContainer,
        tonalElevation = 2.dp,

        ) {
        items.forEach { item ->
            val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            NavigationBarItem(
                label = {
                    Text(
                        text = item.route,
                        color = costumeTheme().textBold
                    )
                },
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpToRoute
                        launchSingleTop
                        restoreState
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (selected)
                            item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.route,
                        tint = costumeTheme().primary,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = costumeTheme().lightWeightText,
                    selectedTextColor = costumeTheme().textBold
                ),

                )
        }

    }
}

@Preview(
    name = "BottomNavigation",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "BottomNavigation",
)
@Composable
fun BottomBarPreview() {
    BottomBar(navController = rememberNavController())
}
