package com.fiveexceptions.seismocon.dashboard.myAccount.alertSetting

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.core.commonComposables.popSafeBack
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.ui.Blue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.GradientRed
import com.fiveexceptions.seismocon.ui.Gray
import com.fiveexceptions.seismocon.ui.Gray2
import com.fiveexceptions.seismocon.ui.White10Per
import com.fiveexceptions.seismocon.ui.White30Per
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color
import seismocon.composeapp.generated.resources.img_alert_setting
import seismocon.composeapp.generated.resources.inter_medium
import seismocon.composeapp.generated.resources.inter_regular

@Composable
fun AlertSettingScreen(navController: NavController) {
    var phoneNumber by remember { mutableStateOf("707-363-6035") }
    var isPhoneNumberTfEnabled by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("mike@seismocon.com") }
    var isEmailTfEnabled by remember { mutableStateOf(false) }
    var location by remember { mutableStateOf("3193 Tiffany Lane, Napa...") }

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientRed, GradientLightBlue), angle = -56f)
        ) {

            Scaffold(
                containerColor = Color.Transparent, modifier = Modifier.fillMaxSize()
            ) { paddingValues ->

                Column(
                    modifier = Modifier.fillMaxSize().padding(paddingValues),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                    ) {
                        LabelText(
                            text = "Alert Message",
                            modifier = Modifier.fillMaxWidth().align(Alignment.Center),
                            textStyle = MaterialTheme.typography.titleMedium
                        )

                        Box(
                            modifier = Modifier.size(36.dp).background(
                                color = White10Per, shape = RoundedCornerShape(8.dp)
                            ).padding(7.dp).clickable(
                                onClick = {
                                    navController.popSafeBack()
                                }).align(Alignment.CenterStart)
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.ic_back_white_color),
                                contentDescription = "Go back",
                                tint = Color.White,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                    Column(
                        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
                    ) {

                        Text(
                            "Earthquake Warning",
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(top = 30.dp).fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(12.dp)
                                ).padding(horizontal = 20.dp, vertical = 30.dp)
                        ) {

                            Text(
                                "Fly islands ( South )",
                                color = Color.Black,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Medium,
                                fontFamily = FontFamily(Font(Res.font.inter_medium))
                            )

                            Image(
                                painterResource(Res.drawable.img_alert_setting),
                                contentDescription = null,
                                modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                                    .height(180.dp).clip(RoundedCornerShape(12.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.height(30.dp))

                            Row(Modifier.fillMaxWidth()) {
                                Text(
                                    text = "Date",
                                    modifier = Modifier,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = FontFamily(Font(Res.font.inter_medium)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Start
                                )

                                Text(
                                    text = "24 July 2023",
                                    modifier = Modifier.weight(1f),
                                    color = Gray2,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily(Font(Res.font.inter_regular)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.End
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Row(Modifier.fillMaxWidth()) {
                                Text(
                                    text = "Time",
                                    modifier = Modifier,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = FontFamily(Font(Res.font.inter_medium)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Start
                                )

                                Text(
                                    text = "UTC 02:49:59",
                                    modifier = Modifier.weight(1f),
                                    color = Gray2,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily(Font(Res.font.inter_regular)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.End
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Row(Modifier.fillMaxWidth()) {
                                Text(
                                    text = "Magnitude",
                                    modifier = Modifier,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = FontFamily(Font(Res.font.inter_medium)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Start
                                )

                                Text(
                                    text = "60",
                                    modifier = Modifier.weight(1f),
                                    color = Gray2,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = FontFamily(Font(Res.font.inter_medium)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.End
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Row(Modifier.fillMaxWidth()) {
                                Text(
                                    text = "Depth",
                                    modifier = Modifier,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = FontFamily(Font(Res.font.inter_medium)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Start
                                )

                                Text(
                                    text = "553Km",
                                    modifier = Modifier.weight(1f),
                                    color = Gray2,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily(Font(Res.font.inter_regular)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.End
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Row(Modifier.fillMaxWidth()) {
                                Text(
                                    text = "Location",
                                    modifier = Modifier,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = FontFamily(Font(Res.font.inter_medium)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Start
                                )

                                Text(
                                    text = "195817.IS 178 16 18 2E",
                                    modifier = Modifier.weight(1f),
                                    color = Gray2,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily(Font(Res.font.inter_regular)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.End
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(Modifier.fillMaxWidth()) {
                                Text(
                                    text = "Event ID",
                                    modifier = Modifier,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = FontFamily(Font(Res.font.inter_medium)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.Start
                                )

                                Text(
                                    text = "us 7000khw8",
                                    modifier = Modifier.weight(1f),
                                    color = Gray2,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = FontFamily(Font(Res.font.inter_regular)),
                                    style = MaterialTheme.typography.titleMedium,
                                    textAlign = TextAlign.End
                                )
                            }
                        }

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(12.dp)
                                ).padding(horizontal = 20.dp, vertical = 20.dp)
                        ) {
                            Text(
                                "1,355 miles from your home",
                                color = Color.Black,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Medium,
                                fontFamily = FontFamily(Font(Res.font.inter_medium))
                            )
                        }

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .background(color = Color.White, shape = RoundedCornerShape(12.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(12.dp)
                                ).padding(horizontal = 20.dp, vertical = 20.dp)
                        ) {
                            Text(
                                "Did you feel it ?",
                                color = Color.Black,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily(Font(Res.font.inter_regular))
                            )

                            Row(
                                modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Button(
                                    onClick = {},
                                    modifier = Modifier
                                        .weight(0.5f), border = BorderStroke(1.dp, color = Gray),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent
                                    ),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Text(
                                        text = "No",
                                        color = Color.Black,
                                        modifier = Modifier.padding(vertical = 8.dp),
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                                    )
                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Button(
                                    onClick = {},
                                    modifier = Modifier
                                        .weight(0.5f),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Blue
                                    ),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Text(
                                        text = "Yes",
                                        color = Color.White,
                                        modifier = Modifier.padding(vertical = 8.dp),
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(50.dp))
                    }
                }
            }
        }
    }
}