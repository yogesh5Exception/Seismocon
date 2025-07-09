package com.fiveexceptions.seismocon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fiveexceptions.seismocon.dashboard.home.HomeScreen
import com.fiveexceptions.seismocon.splash.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            App()
//            LoginScreen()
//            ForgotPasswordScreen()
//            HomeScreen()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}