package com.jocelinoafonsofernandes.splayer

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.jocelinoafonsofernandes.splayer.data.callbacks.NavigationCallBack
import com.jocelinoafonsofernandes.splayer.data.global.GlobalState
import com.jocelinoafonsofernandes.splayer.data.global.SharedEvents
import com.jocelinoafonsofernandes.splayer.data.provider.ViewModelProvider
import com.jocelinoafonsofernandes.splayer.ui.theme.SplayerTheme
import com.jocelinoafonsofernandes.splayer.ui.theme.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import java.security.Permission
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    @Inject
    lateinit var globalState: GlobalState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        askExternalAccessPermission()
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

    private fun hasReadAExternalStoragePermission() = ContextCompat.checkSelfPermission(
        this,
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    ) == PackageManager.PERMISSION_GRANTED

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == READ_EXTERNAL_STORAGE_PERMISSION_CODE && resultCode != RESULT_OK) {
            Toast.makeText(this, R.string.permission_rational, Toast.LENGTH_LONG).show()
            return
        }
        globalState.onEvent(SharedEvents.SetReadExternalStoragePermissionState(true))
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun askExternalAccessPermission() {
        if (!hasReadAExternalStoragePermission()) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                READ_EXTERNAL_STORAGE_PERMISSION_CODE
            )
        }

    }

    companion object {
        const val READ_EXTERNAL_STORAGE_PERMISSION_CODE = 100
    }
}


