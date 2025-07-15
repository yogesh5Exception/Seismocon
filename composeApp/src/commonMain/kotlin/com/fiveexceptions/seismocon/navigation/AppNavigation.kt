package com.fiveexceptions.seismocon.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
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
import com.fiveexceptions.seismocon.dashboard.notification.NotificationScreen
import com.fiveexceptions.seismocon.splash.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(onNavHostReady: suspend (NavController) -> Unit = {}) {
    val navController = rememberNavController()
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
            NotificationScreen()
        }

    }

    LaunchedEffect(navController) {
        onNavHostReady(navController)
    }
}