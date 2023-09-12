package com.jocelinoafonsofernandes.splayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jocelinoafonsofernandes.splayer.data.callbacks.NavigationCallBack
import com.jocelinoafonsofernandes.splayer.data.provider.ViewModelProvider
import com.jocelinoafonsofernandes.splayer.ui.theme.SplayerTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplayerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var showBottomNavbar by remember {
                        mutableStateOf(true)
                    }
                    val hideBottomNavBar = {
                        showBottomNavbar = false
                    }
                    val showBottomNav = {
                        showBottomNavbar = true

                    }
                    val navController = rememberNavController()
                    Navigation(
                        navController = navController,
                        navigationCallBack = NavigationCallBack(
                            hideBottomNavBar = hideBottomNavBar,
                            showBottomNavBar = showBottomNav,
                            showBottomNavigation = showBottomNavbar,
                            viewModelHodler = viewModelProvider.provideViewModels()
                        )
                    )
                }
            }
        }
    }
}


