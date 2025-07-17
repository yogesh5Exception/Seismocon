package com.fiveexceptions.seismocon.dashboard.myAccount.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.core.commonComposables.popSafeBack
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.LightBlue
import com.fiveexceptions.seismocon.ui.White10Per
import com.fiveexceptions.seismocon.ui.White30Per
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color
import seismocon.composeapp.generated.resources.img_shop
import seismocon.composeapp.generated.resources.inter_medium

@Composable
fun ShopScreen(navController: NavController) {
    var signMeUpCheck by rememberSaveable { mutableStateOf(true) }

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {
            Scaffold(containerColor = Color.Transparent) { paddingValues ->
                Column(
                    modifier = Modifier.fillMaxSize().padding(paddingValues)
                        .padding(horizontal = 20.dp).verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AppIconImage(
                        modifier = Modifier.fillMaxWidth()
                            .padding(horizontal = 20.dp).heightIn(90.dp)
                    )

                    Box(
                        modifier = Modifier.padding(top = 30.dp).fillMaxWidth()
                    ) {
                        LabelText(
                            text = "Help us help you stay safe",
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

                    Text(
                        "Be among the first to monitor your home for earthquakes.",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                    Text(
                        "Sign up now, and we’ll notify you as soon as orders open!",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                    Column(
                        modifier = Modifier.padding(top = 30.dp).fillMaxWidth().border(
                            width = 1.dp, color = Color.White, shape = RoundedCornerShape(12.dp)
                        ).background(color = LightBlue, shape = RoundedCornerShape(12.dp))
                    )
                    {
                        Text(
                            "Seismocon Monitoring Unit",
                            color = Color.White,
                            modifier = Modifier.padding(top = 12.dp).fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium)),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Start
                        )

                        Box(
                            modifier = Modifier.padding(top = 12.dp).fillMaxWidth().height(1.dp)
                                .background(color = Color.White)
                        )


                        Text(
                            "Estimated release July 2026",
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                                .padding(horizontal = 20.dp),
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Row(
                            modifier = Modifier.padding(top = 10.dp).fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painterResource(Res.drawable.img_shop),
                                contentDescription = null,
                                modifier = Modifier.size(80.dp)
                            )

                            Text(
                                "Yes, please sign me up! ",
                                color = Color.White,
                                modifier = Modifier.weight(1f).padding(horizontal = 10.dp),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Medium,
                                fontFamily = FontFamily(Font(Res.font.inter_medium)),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Start
                            )

                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(RoundedCornerShape(3.dp))
                                    .border(
                                        width = 1.dp,
                                        color = White30Per,
                                        shape = RoundedCornerShape(3.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Checkbox(
                                    checked = signMeUpCheck,
                                    onCheckedChange = { signMeUpCheck = it },
                                    modifier = Modifier.size(20.dp).clip(RoundedCornerShape(3.dp))
                                        .padding(4.dp),
                                    colors = CheckboxDefaults.colors(
                                        checkmarkColor = Color.White,
                                        checkedColor = Color.Transparent,
                                        uncheckedColor = Color.Transparent
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    Text(
                        "No commitment. No Shop",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                    Text(
                        "We’ll check back with you when we're ready to ship.",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )
                }

                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}