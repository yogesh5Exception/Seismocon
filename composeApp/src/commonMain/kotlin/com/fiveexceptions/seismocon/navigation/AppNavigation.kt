package com.fiveexceptions.seismocon.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fiveexceptions.seismocon.auth.ForgotPasswordScreen
import com.fiveexceptions.seismocon.auth.LoginScreen
import com.fiveexceptions.seismocon.dashboard.DashboardScreen
import com.fiveexceptions.seismocon.dashboard.home.HomeScreen
import com.fiveexceptions.seismocon.dashboard.home.earthquakesNow.EarthquakesNowScreen
import com.fiveexceptions.seismocon.dashboard.home.myObject.MyObjectScreen
import com.fiveexceptions.seismocon.dashboard.home.myObject.myObjectDetails.MyObjectDetailsScreen
import com.fiveexceptions.seismocon.dashboard.home.myObject.myObjectInviteAFriend.MyObjectInviteAFriendScreen
import com.fiveexceptions.seismocon.dashboard.home.myObject.myObjectReportsAndNotification.MyObjectReportsAndNotificationScreen
import com.fiveexceptions.seismocon.dashboard.home.mySeismocon.MySeismoconScreen
import com.fiveexceptions.seismocon.dashboard.home.science.ScienceScreen
import com.fiveexceptions.seismocon.dashboard.home.technology.TechnologyScreen
import com.fiveexceptions.seismocon.dashboard.menu.MenuScreen
import com.fiveexceptions.seismocon.dashboard.myAccount.MyAccountScreen
import com.fiveexceptions.seismocon.dashboard.myAccount.alertSetting.AlertSettingScreen
import com.fiveexceptions.seismocon.dashboard.myAccount.friendsAndFamily.FriendsAndFamilyScreen
import com.fiveexceptions.seismocon.dashboard.myAccount.securityAndLegal.LegalScreen
import com.fiveexceptions.seismocon.dashboard.myAccount.securityAndLegal.SecurityScreen
import com.fiveexceptions.seismocon.dashboard.myAccount.shop.ShopScreen
import com.fiveexceptions.seismocon.dashboard.notification.NotificationScreen
import com.fiveexceptions.seismocon.splash.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(onNavHostReady: suspend (NavController) -> Unit = {}) {
    val navController: NavHostController = rememberNavController()
    NavHost(navController, startDestination = SplashScreen) {
        composable<SplashScreen> {
            SplashScreen {
                // if user is already logged in , go to home otherwise login
                navController.navigate(LoginScreen) {
                    popUpTo(navController.graph.id)
                }
            }
        }

        composable<LoginScreen> {
            LoginScreen(
                signInClick = {
                    navController.navigate(DashboardScreen) {
                        popUpTo(navController.graph.id)
                    }
                },
                guestClick = {

                },
                forgotPasswordClick = {
                    navController.navigate(ForgotPasswordScreen)
                }
            )
        }

        composable<ForgotPasswordScreen> {
            ForgotPasswordScreen()
        }

        composable<HomeScreen> {
            HomeScreen(navController)
        }

        composable<MyObjectScreen> {
            MyObjectScreen(navController)
        }

        composable<MySeismoconScreen> {
            MySeismoconScreen(navController)
        }

        composable<TechnologyScreen> {
            TechnologyScreen(navController)
        }

        composable<EarthquakesNowScreen> {
            EarthquakesNowScreen(navController)
        }

        composable<ScienceScreen> {
            ScienceScreen(navController)
        }

        composable<MyObjectDetailsScreen> {
            MyObjectDetailsScreen(navController)
        }

        composable<MyObjectInviteAFriendScreen> {
            MyObjectInviteAFriendScreen(navController)
        }

        composable<MyObjectReportsAndNotificationScreen> {
            MyObjectReportsAndNotificationScreen(navController)
        }

        composable<DashboardScreen> {
            DashboardScreen(navController)
        }

        composable<NotificationScreen> {
            NotificationScreen(navController)
        }

        composable<MyAccountScreen> {
            MyAccountScreen(navController)
        }

        composable<MenuScreen> {
            MenuScreen(navController)
        }

        composable<FriendsAndFamilyScreen> {
            FriendsAndFamilyScreen(navController)
        }

        composable<SecurityScreen> {
            SecurityScreen(navController)
        }

        composable<LegalScreen> {
            LegalScreen(navController)
        }

        composable<AlertSettingScreen> {
            AlertSettingScreen(navController)
        }

        composable<ShopScreen> {
            ShopScreen(navController)
        }
    }

    LaunchedEffect(navController) {
        onNavHostReady(navController)
    }
}