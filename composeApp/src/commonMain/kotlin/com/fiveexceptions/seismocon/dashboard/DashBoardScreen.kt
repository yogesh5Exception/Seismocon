package com.fiveexceptions.seismocon.dashboard

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.dashboard.home.HomeScreen
import com.fiveexceptions.seismocon.navigation.NotificationScreen
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_home
import seismocon.composeapp.generated.resources.ic_menu
import seismocon.composeapp.generated.resources.ic_notification
import seismocon.composeapp.generated.resources.ic_profile

data class BottomNavigationItem(
    val unselectedIcon: DrawableResource,
    val selectedIcon: DrawableResource,
    val label: String
)

@Composable
@Preview
fun DashboardScreen(navController: NavController) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val items = listOf(
        BottomNavigationItem(
            unselectedIcon = Res.drawable.ic_home,
            selectedIcon = Res.drawable.ic_home,
            label = "Home"
        ),
        BottomNavigationItem(
            unselectedIcon = Res.drawable.ic_notification,
            selectedIcon = Res.drawable.ic_notification,
            label = "Notifications"
        ),
        BottomNavigationItem(
            unselectedIcon = Res.drawable.ic_profile,
            selectedIcon = Res.drawable.ic_profile,
            label = "Profile"
        ),
        BottomNavigationItem(
            unselectedIcon = Res.drawable.ic_menu,
            selectedIcon = Res.drawable.ic_menu,
            label = "Menu"
        )
    )
    MaterialTheme {
        Scaffold(bottomBar = {
            NavigationBar() {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index

                            if (selectedItemIndex == 0) {

                            } else if (selectedItemIndex == 1) {
                                navController.navigate(NotificationScreen)
                            } else if (selectedItemIndex == 2) {

                            } else {

                            }

                        },
                        icon = {
                            Icon(
                                painterResource(item.selectedIcon),
                                contentDescription = item.label, modifier = Modifier.size(20.dp)
                            )
                        }, label = {
                            Text(text = item.label)
                        }, alwaysShowLabel = false
                    )
                }
            }
        }) {

            HomeScreen(navController = navController)
        }
    }
}