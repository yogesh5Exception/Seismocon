package com.fiveexceptions.seismocon.dashboard.myAccount.securityAndLegal

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.navigation.LegalScreen
import com.fiveexceptions.seismocon.ui.Blue
import com.fiveexceptions.seismocon.ui.Blue30
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.White10Per
import com.fiveexceptions.seismocon.ui.White50Per
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color
import seismocon.composeapp.generated.resources.inter_medium
import seismocon.composeapp.generated.resources.inter_regular

@Composable
fun SecurityScreen(navController: NavController) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var newPassword by rememberSaveable { mutableStateOf("") }
    var repeatNewPassword by rememberSaveable { mutableStateOf("") }

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {
            Scaffold(containerColor = Color.Transparent) { paddingValues ->
                Column(
                    modifier = Modifier.fillMaxSize().padding(paddingValues)
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
                            .padding(30.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Security",
                            color = Color.White,
                            modifier = Modifier,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_regular))
                        )
                        Button(
                            onClick = { navController.navigate(LegalScreen) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Blue
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                "Legal",
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily(Font(Res.font.inter_regular))
                            )
                        }
                    }

                    Text(
                        text = "Change Password",
                        modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily(Font(Res.font.inter_medium)),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        "Update your Password for enhanced account security",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth().padding(
                            top = 10.dp
                        ).padding(end = 30.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                    Text(
                        text = "User Name",
                        modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily(Font(Res.font.inter_medium)),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start
                    )

                    Box(
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth().border(
                            width = 1.dp, color = White50Per, shape = RoundedCornerShape(3.dp)
                        ).clip(RoundedCornerShape(3.dp))
                    ) {
                        TextField(
                            value = username,
                            onValueChange = { username = it },
                            modifier = Modifier.fillMaxWidth(),
                            colors = TextFieldDefaults.colors(
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White,
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.White
                            ),
                            textStyle = TextStyle(
                                fontFamily = FontFamily(Font(Res.font.inter_regular)),
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp, // optional
                            ),
                            singleLine = true
                        )
                    }

                    Text(
                        text = "Password",
                        modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily(Font(Res.font.inter_medium)),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start
                    )

                    Box(
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth().border(
                            width = 1.dp, color = White50Per, shape = RoundedCornerShape(3.dp)
                        ).clip(RoundedCornerShape(3.dp))
                    ) {
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            modifier = Modifier.fillMaxWidth(),
                            colors = TextFieldDefaults.colors(
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White,
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.White
                            ),
                            textStyle = TextStyle(
                                fontFamily = FontFamily(Font(Res.font.inter_regular)),
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp, // optional
                            ),
                            singleLine = true
                        )
                    }

                    Box(
                        modifier = Modifier.padding(top = 40.dp).fillMaxWidth().height(1.dp)
                            .background(color = White10Per)
                    )

                    Text(
                        text = "New Passwords",
                        modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily(Font(Res.font.inter_medium)),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start
                    )

                    Box(
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth().border(
                            width = 1.dp, color = White50Per, shape = RoundedCornerShape(3.dp)
                        ).clip(RoundedCornerShape(3.dp))
                    ) {
                        TextField(
                            value = newPassword,
                            onValueChange = { newPassword = it },
                            modifier = Modifier.fillMaxWidth(),
                            colors = TextFieldDefaults.colors(
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White,
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.White
                            ),
                            textStyle = TextStyle(
                                fontFamily = FontFamily(Font(Res.font.inter_regular)),
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp, // optional
                            ),
                            singleLine = true
                        )
                    }

                    Text(
                        text = "Repeat New Password",
                        modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily(Font(Res.font.inter_medium)),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start
                    )

                    Box(
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth().border(
                            width = 1.dp, color = White50Per, shape = RoundedCornerShape(3.dp)
                        ).clip(RoundedCornerShape(3.dp))
                    ) {
                        TextField(
                            value = repeatNewPassword,
                            onValueChange = { repeatNewPassword = it },
                            modifier = Modifier.fillMaxWidth(),
                            colors = TextFieldDefaults.colors(
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White,
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.White
                            ),
                            textStyle = TextStyle(
                                fontFamily = FontFamily(Font(Res.font.inter_regular)),
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp, // optional
                            ),
                            singleLine = true
                        )
                    }

                    Button(
                        onClick = { navController.navigateUp() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Blue
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.padding(top = 40.dp)
                    ) {
                        Text(
                            "Submit",
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )
                    }


                    Button(
                        onClick = { navController.navigateUp() },
                        modifier = Modifier.padding(top = 30.dp).border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(12.dp)
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {

                        Icon(
                            painter = painterResource(Res.drawable.ic_back_white_color),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Text(
                            "Back",
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )
                    }

                    Spacer(modifier = Modifier.height(50.dp))
                }
            }
        }
    }
}