package com.fiveexceptions.seismocon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fiveexceptions.seismocon.dashboard.notification.NotificationScreen
import com.fiveexceptions.seismocon.navigation.App


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            App()
//            LoginScreen()
//            ForgotPasswordScreen()
//            HomeScreen()
//            AllSensorsNow()
//            MyObjectScreen()
//            MyObjectDetailsScreen()
//            MyObjectReportsAndNotificationScreen()
//            MyObjectMySeismoconScreen()
//            MyObjectInviteAFriendScreen()
//            NotificationScreen()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}