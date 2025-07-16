package com.fiveexceptions.seismocon.dashboard.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun MenuScreen(navController: NavController) {

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {

            Column(
                modifier = Modifier.fillMaxSize().padding(top = 26.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }
        }
    }
}

