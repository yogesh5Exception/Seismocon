package com.fiveexceptions.seismocon.dashboard.myAccount.securityAndLegal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.navigation.LegalScreen
import com.fiveexceptions.seismocon.ui.Blue
import com.fiveexceptions.seismocon.ui.Blue30
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import org.jetbrains.compose.resources.Font
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.inter_medium
import seismocon.composeapp.generated.resources.inter_semibold

@Composable
fun SecurityScreen(navController: NavController) {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {
            Scaffold(containerColor = Color.Transparent) { paddingValues ->
                Column(
                    modifier = Modifier.fillMaxSize().padding(paddingValues).padding(top = 20.dp)
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AppIconImage(
                        modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                            .padding(horizontal = 20.dp).heightIn(90.dp)
                    )

                    Row(
                        modifier = Modifier.padding(top = 30.dp).fillMaxWidth()
                            .background(color = Blue30, shape = RoundedCornerShape(12.dp))
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            "Security",
                            color = Color.White,
                            modifier = Modifier,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Button(
                            onClick = { navController.navigate(LegalScreen) },
                            modifier = Modifier
                                .padding(horizontal = 30.dp, vertical = 16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Blue
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                "Legal",
                                color = Color.White,
                                modifier = Modifier,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Medium,
                                fontFamily = FontFamily(Font(Res.font.inter_medium))
                            )
                        }
                    }

                    Text(
                        "The following people have access to your account :",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth().padding(
                            top = 30.dp
                        ).padding(end = 30.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                }
            }

        }
    }
}