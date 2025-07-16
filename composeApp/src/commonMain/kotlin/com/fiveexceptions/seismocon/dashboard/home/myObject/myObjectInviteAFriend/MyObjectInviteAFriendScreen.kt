package com.fiveexceptions.seismocon.dashboard.home.myObject.myObjectInviteAFriend

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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.dashboard.home.myObject.MyObjectItem
import com.fiveexceptions.seismocon.dashboard.home.myObject.data.MyObjectData
import com.fiveexceptions.seismocon.navigation.MyObjectDetailsScreen
import com.fiveexceptions.seismocon.navigation.MyObjectReportsAndNotificationScreen
import com.fiveexceptions.seismocon.navigation.MySeismoconScreen
import com.fiveexceptions.seismocon.ui.Blue
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.Gray
import com.fiveexceptions.seismocon.ui.LightBlue
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color
import seismocon.composeapp.generated.resources.inter_regular
import seismocon.composeapp.generated.resources.inter_semibold

@Composable
fun MyObjectInviteAFriendScreen(navController: NavController) {
    var firstAndLastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var whatIsTheRelation by rememberSaveable { mutableStateOf("") }
    var termsAndConditionCheck by rememberSaveable { mutableStateOf(false) }

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {

            Column(
                modifier = Modifier.fillMaxSize().padding(top = 26.dp)
                    .padding(start = 20.dp, end = 20.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppIconImage(
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                        .padding(horizontal = 20.dp).heightIn(90.dp)
                )

                Box(
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                ) {
                    LabelText(
                        text = "Invitation",
                        modifier = Modifier.fillMaxWidth().align(Alignment.Center),
                        textStyle = MaterialTheme.typography.titleMedium
                    )

                    Box(
                        modifier = Modifier.size(28.dp).border(
                            width = 1.dp, color = Gray, shape = RoundedCornerShape(8.dp)
                        ).padding(6.dp).clickable(onClick = { navController.popBackStack() }).align(Alignment.CenterStart)
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_back_white_color),
                            contentDescription = "Go back",
                            tint = Color.White,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                MyObjectItem(
                    modifier = Modifier.fillMaxWidth().padding(top = 30.dp), item = MyObjectData(
                        propertyName = "Property 1",
                        propertyAddress = "vijay nagar near krishna doodh dairy",
                        id = 1
                    ), onDetailsClick = {
                        navController.popBackStack()
                        navController.navigate(MyObjectDetailsScreen)
                    },
                    onInviteClick = {
//                        navController.popBackStack()
//                        navController.navigate(MyObjectInviteAFriendScreen)
                    },
                    onReportsClick = {
                        navController.popBackStack()
                        navController.navigate(MyObjectReportsAndNotificationScreen)
                    },
                    onMySeismoconClick = {
                        navController.popBackStack()
                        navController.navigate(MySeismoconScreen)
                    }
                )

                Spacer(modifier = Modifier.height(40.dp))

                MyObjectInviteAFriendTexts(
                    modifier = Modifier.fillMaxWidth(),
                    "Please Note",
                    listOf(
                        "The invitee will",
                        "-Receive notification and reports of your objects",
                        "-Be able to see all data of in the object manager"
                    )
                )

                Spacer(modifier = Modifier.height(30.dp))

                MyObjectInviteAFriendTexts(
                    modifier = Modifier.fillMaxWidth(),
                    "The Invitee cannot",
                    listOf(
                        "-Change settings or details",
                        "-Change passwords or have access to the password"
                    )
                )

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    "The Invitee",
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(Res.font.inter_semibold))
                )


                Column(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .background(
                            color = LightBlue,
                            shape = RoundedCornerShape(12.dp)
                        ).padding(all = 16.dp),

                    ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "First and last name:",
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth().weight(0.5f),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_regular))
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f)
                                .border(1.dp, Gray, RoundedCornerShape(3.dp))
                                .clip(RoundedCornerShape(3.dp))
                                .background(Color.Transparent)
                                .height(40.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            BasicTextField(
                                value = firstAndLastName,
                                onValueChange = { firstAndLastName = it },
                                singleLine = true,
                                textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(Res.font.inter_regular))
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                cursorBrush = SolidColor(Color.White)
                            )
                        }

                    }

                    Row(
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Email:",
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth().weight(0.5f),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_regular))
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f)
                                .border(1.dp, Gray, RoundedCornerShape(3.dp))
                                .clip(RoundedCornerShape(3.dp))
                                .background(Color.Transparent)
                                .height(40.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            BasicTextField(
                                value = email,
                                onValueChange = { email = it },
                                singleLine = true,
                                textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(Res.font.inter_regular))
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                cursorBrush = SolidColor(Color.White)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Phone:",
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth().weight(0.5f),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_regular))
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f)
                                .border(1.dp, Gray, RoundedCornerShape(3.dp))
                                .clip(RoundedCornerShape(3.dp))
                                .background(Color.Transparent)
                                .height(40.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            BasicTextField(
                                value = phone,
                                onValueChange = { phone = it },
                                singleLine = true,
                                textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(Res.font.inter_regular))
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                cursorBrush = SolidColor(Color.White)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "What is the relation:",
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth().weight(0.5f),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_regular))
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f)
                                .border(1.dp, Gray, RoundedCornerShape(3.dp))
                                .clip(RoundedCornerShape(3.dp))
                                .background(Color.Transparent)
                                .height(40.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            BasicTextField(
                                value = whatIsTheRelation,
                                onValueChange = { whatIsTheRelation = it },
                                singleLine = true,
                                textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(Res.font.inter_regular))
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                cursorBrush = SolidColor(Color.White)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Checkbox(
                                checked = termsAndConditionCheck,
                                onCheckedChange = { termsAndConditionCheck = it },
                                modifier = Modifier.size(20.dp).clip(RoundedCornerShape(3.dp))
                                    .padding(4.dp),
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color.White,
                                    uncheckedColor = Color.White,
                                    checkmarkColor = LightBlue
                                )
                            )
                        }

                        Text(
                            "I accept the terms & conditions",
                            color = Color.White,
                            modifier = Modifier.padding(10.dp).fillMaxWidth().weight(1f),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_regular))
                        )

                        Text(
                            text = "Submit",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(start = 10.dp).background(
                                Blue, shape = RoundedCornerShape(4.dp)
                            ).padding(horizontal = 16.dp).padding(vertical = 6.dp),
                            fontFamily = FontFamily(Font(Res.font.inter_regular)),
                        )
                    }
                }


                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Composable
fun MyObjectInviteAFriendTexts(
    modifier: Modifier = Modifier,
    title: String,
    descriptions: List<String>
) {
    Column(modifier = modifier) {
        Text(
            title,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(Res.font.inter_semibold))
        )

        descriptions.forEach { item ->
            Text(
                item,
                color = Color.White,
                modifier = Modifier.padding(top = 5.dp).fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(Res.font.inter_regular))
            )
        }
    }
}