package com.jocelinoafonsofernandes.splayer.data.callbacks

import com.jocelinoafonsofernandes.splayer.data.entities.ViewModelHoder

data class NavigationCallBack(
    val showBottomNavigation: Boolean = false,
    val hideBottomNavBar: () -> Unit,
    val showBottomNavBar: () -> Unit,
    val viewModelHodler: ViewModelHoder? = null
)