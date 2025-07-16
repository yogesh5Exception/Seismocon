package com.fiveexceptions.seismocon.dashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.dashboard.home.HomeScreen
import com.fiveexceptions.seismocon.navigation.MenuScreen
import com.fiveexceptions.seismocon.navigation.MyAccountScreen
import com.fiveexceptions.seismocon.navigation.NotificationScreen
import com.fiveexceptions.seismocon.ui.DashboardBg
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_home
import seismocon.composeapp.generated.resources.ic_menu
import seismocon.composeapp.generated.resources.ic_notification
import seismocon.composeapp.generated.resources.ic_profile

data class BottomNavigationItem(
    val icon: DrawableResource, val label: String
)

@Composable
@Preview
fun DashboardScreen(navController: NavController) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = listOf(
        BottomNavigationItem(
            icon = Res.drawable.ic_home, label = "Home"
        ), BottomNavigationItem(
            icon = Res.drawable.ic_notification, label = "Notifications"
        ), BottomNavigationItem(
            icon = Res.drawable.ic_profile, label = "Profile"
        ), BottomNavigationItem(
            icon = Res.drawable.ic_menu, label = "Menu"
        )
    )
    MaterialTheme {
        Scaffold(bottomBar = {
            Surface(
                color = DashboardBg,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                shadowElevation = 8.dp
            ) {
                NavigationBar(
                    containerColor = Color.Transparent,
                    tonalElevation = 0.dp
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = index == selectedItemIndex, onClick = {
                                when (item.label) {
                                    "Home" -> selectedItemIndex = index
                                    "Notifications" -> navController.navigate(NotificationScreen)
                                    "Profile" -> navController.navigate(MyAccountScreen)
                                    "Menu" -> navController.navigate(MenuScreen)
                                }
                            }, icon = {
                                val icon = when (item.label) {
                                    "Home" -> Res.drawable.ic_home
                                    "Notifications" -> Res.drawable.ic_notification
                                    "Profile" -> Res.drawable.ic_profile
                                    "Menu" -> Res.drawable.ic_menu
                                    else -> Res.drawable.ic_home
                                }
                                Icon(
                                    painterResource(icon),
                                    contentDescription = item.label,
                                    modifier = Modifier.size(36.dp)
                                        .padding(if (item.label == "Profile") 0.dp else 7.dp),
                                    tint = Color.Unspecified
                                )
                            }, alwaysShowLabel = false,
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Unspecified,
                                unselectedIconColor = Color.Unspecified,
                                indicatorColor = Color.Transparent
                            )
                        )
                    }
                }
            }
        }) { paddingValues ->
            when (selectedItemIndex) {
                0 -> HomeScreen(
                    modifier = Modifier.padding(paddingValues), navController = navController
                )
            }
        }
    }
}