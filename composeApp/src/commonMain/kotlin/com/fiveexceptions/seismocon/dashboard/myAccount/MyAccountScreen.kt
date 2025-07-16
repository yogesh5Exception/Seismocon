package com.fiveexceptions.seismocon.dashboard.myAccount

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.navigation.FriendsAndFamilyScreen
import com.fiveexceptions.seismocon.navigation.SecurityScreen
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.LightBlue
import com.fiveexceptions.seismocon.ui.White10Per
import com.fiveexceptions.seismocon.ui.White20Per
import com.fiveexceptions.seismocon.ui.White30Per
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_alert
import seismocon.composeapp.generated.resources.ic_arrow
import seismocon.composeapp.generated.resources.ic_back_white_color
import seismocon.composeapp.generated.resources.ic_edit
import seismocon.composeapp.generated.resources.ic_location
import seismocon.composeapp.generated.resources.ic_mail
import seismocon.composeapp.generated.resources.ic_my_object
import seismocon.composeapp.generated.resources.ic_notification_white
import seismocon.composeapp.generated.resources.ic_phone
import seismocon.composeapp.generated.resources.ic_security
import seismocon.composeapp.generated.resources.ic_shop
import seismocon.composeapp.generated.resources.ic_user2
import seismocon.composeapp.generated.resources.img_my_account
import seismocon.composeapp.generated.resources.inter_medium
import seismocon.composeapp.generated.resources.inter_semibold

@Composable
@Preview
fun MyAccountScreen(navController: NavController) {
    var isNavigating by remember { mutableStateOf(false) }
    var phoneNumber by remember { mutableStateOf("707-363-6035") }
    var isPhoneNumberTfEnabled by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("mike@seismocon.com") }
    var isEmailTfEnabled by remember { mutableStateOf(false) }
    var location by remember { mutableStateOf("3193 Tiffany Lane, Napa...") }

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {

            Scaffold(
                containerColor = Color.Transparent, modifier = Modifier.fillMaxSize()
            ) { paddingValues ->

                Column(
                    modifier = Modifier.fillMaxSize().padding(paddingValues).padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                    ) {
                        LabelText(
                            text = "My Account",
                            modifier = Modifier.fillMaxWidth().align(Alignment.Center),
                            textStyle = MaterialTheme.typography.titleMedium
                        )

                        Box(
                            modifier = Modifier.size(28.dp).background(
                                color = White10Per, shape = RoundedCornerShape(8.dp)
                            ).padding(7.dp).clickable(
                                enabled = !isNavigating, onClick = {
                                    if (!isNavigating) {
                                        isNavigating = true
                                        navController.popBackStack()
                                    }
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
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(top = 40.dp).fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .background(color = LightBlue, shape = RoundedCornerShape(12.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(12.dp)
                                ).padding(horizontal = 20.dp, vertical = 30.dp)
                        ) {
                            Image(
                                painterResource(Res.drawable.img_my_account),
                                contentDescription = null,
                                modifier = Modifier.size(90.dp).clip(RoundedCornerShape(12.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = "Mike Sjoblom",
                                modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
                                color = Color.White,
                                fontWeight = FontWeight.Medium,
                                fontFamily = FontFamily(Font(Res.font.inter_medium)),
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Center
                            )
                        }

                        MyAccountOptions(
                            modifier = Modifier.fillMaxWidth().padding(top = 40.dp),
                            Res.drawable.ic_phone,
                            phoneNumber,
                            isEditable = true,
                            editToggle = isPhoneNumberTfEnabled,
                            ifEditableThenChangeListener = { phoneNumber = it },
                            editToggleFunc = { isPhoneNumberTfEnabled = it })

                        MyAccountOptions(
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            Res.drawable.ic_mail,
                            email,
                            isEditable = true,
                            editToggle = isEmailTfEnabled,
                            ifEditableThenChangeListener = { email = it },
                            editToggleFunc = { isEmailTfEnabled = it })

                        MyAccountOptions(
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            Res.drawable.ic_location,
                            location,
                            isEditable = false,
                            onClick = {})


                        MyAccountOptions(
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            Res.drawable.ic_user2,
                            "Family & Friends",
                            isEditable = false,
                            onClick = { navController.navigate(FriendsAndFamilyScreen) })

                        MyAccountOptions(
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            Res.drawable.ic_alert,
                            "Alert Settings",
                            isEditable = false,
                            onClick = {})

                        MyAccountOptions(
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            Res.drawable.ic_my_object,
                            "My Objects",
                            isEditable = false,
                            onClick = {})

                        MyAccountOptions(
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            Res.drawable.ic_notification_white,
                            "Notification & Reports",
                            isEditable = false,
                            onClick = {})

                        MyAccountOptions(
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            Res.drawable.ic_shop,
                            "Shop",
                            isEditable = false,
                            onClick = {})

                        MyAccountOptions(
                            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                            Res.drawable.ic_security,
                            "Security and Legal",
                            isEditable = false,
                            onClick = { navController.navigate(SecurityScreen) })

                    }
                }
            }
        }
    }
}

@Composable
fun MyAccountOptions(
    modifier: Modifier = Modifier,
    drawableResource: DrawableResource,
    text: String,
    editToggle: Boolean? = null,
    isEditable: Boolean = false,
    onClick: (() -> Unit)? = null,
    ifEditableThenChangeListener: ((String) -> Unit)? = null,
    editToggleFunc: ((Boolean) -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .clickable(enabled = !isEditable, onClick = { onClick?.invoke() })
    ) {
        Row(
            modifier = modifier.padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier.border(
                    width = 1.dp, color = White20Per, shape = RoundedCornerShape(8.dp)
                ).padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(drawableResource),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }

            if (isEditable) {
                Box(
                    modifier = Modifier.fillMaxWidth().weight(1f).background(Color.Transparent),
                    contentAlignment = Alignment.CenterStart
                ) {
                    BasicTextField(
                        value = text,
                        onValueChange = {
                            ifEditableThenChangeListener?.invoke(it)
                        },
                        enabled = editToggle!!,
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color.White,
                            fontFamily = FontFamily(Font(Res.font.inter_semibold))
                        ),
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                        cursorBrush = SolidColor(Color.White)
                    )
                }

                Icon(
                    painter = painterResource(Res.drawable.ic_edit),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                        .clickable(onClick = { editToggleFunc?.invoke(!editToggle!!) })
                )
            } else {
                Text(
                    text = text,
                    modifier = Modifier.weight(1f).padding(horizontal = 30.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = FontFamily(
                        Font(
                            Res.font.inter_semibold
                        )
                    )
                )

                Icon(
                    painter = painterResource(Res.drawable.ic_arrow),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Box(
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth().height(1.dp)
                .background(color = White20Per).padding(horizontal = 20.dp)
        )
    }
}