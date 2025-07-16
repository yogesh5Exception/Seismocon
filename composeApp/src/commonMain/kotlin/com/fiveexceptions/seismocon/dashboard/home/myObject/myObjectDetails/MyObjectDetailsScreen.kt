package com.fiveexceptions.seismocon.dashboard.home.myObject.myObjectDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.dashboard.home.myObject.MyObjectItem
import com.fiveexceptions.seismocon.dashboard.home.myObject.data.MyObjectData
import com.fiveexceptions.seismocon.navigation.MyObjectInviteAFriendScreen
import com.fiveexceptions.seismocon.navigation.MyObjectReportsAndNotificationScreen
import com.fiveexceptions.seismocon.navigation.MySeismoconScreen
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.Gray
import com.fiveexceptions.seismocon.ui.LightBlue
import com.fiveexceptions.seismocon.ui.LightBlue2
import com.fiveexceptions.seismocon.ui.White10Per
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color
import seismocon.composeapp.generated.resources.inter_semibold

@Composable
fun MyObjectDetailsScreen(navController: NavController) {

    val items: List<MyObjectDetailsData> = listOf(
        MyObjectDetailsData("Years of construction", "15"),
        MyObjectDetailsData("Primary Building Material", "15"),
        MyObjectDetailsData("Occupancy", "15"),
        MyObjectDetailsData("Soft Story", "15"),
        MyObjectDetailsData("Seismically Retrofitted", "15"),
        MyObjectDetailsData("Earthquake Insurance", "15"),
        MyObjectDetailsData("Type of building", "15"),
        MyObjectDetailsData("Square footage", "15"),
        MyObjectDetailsData("Soil Class", "15"),
        MyObjectDetailsData("Design Category", "15"),
        MyObjectDetailsData("Nearest Strong Motion Sensor", "15"),
        MyObjectDetailsData("PGA", "15"),
        MyObjectDetailsData("Years of construction", "15"),
        MyObjectDetailsData("Primary Building Material", "15"),
        MyObjectDetailsData("Occupancy", "15"),
        MyObjectDetailsData("Soft Story", "15"),
        MyObjectDetailsData("Seismically Retrofitted", "15"),
        MyObjectDetailsData("Earthquake Insurance", "15"),
        MyObjectDetailsData("Type of building", "15"),
        MyObjectDetailsData("Square footage", "15"),
        MyObjectDetailsData("Soil Class", "15"),
        MyObjectDetailsData("Design Category", "15"),
        MyObjectDetailsData("Nearest Strong Motion Sensor", "15"),
    )

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {

            Column(
                modifier = Modifier.fillMaxSize().padding(top = 26.dp).padding(horizontal = 20.dp)
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
                        text = "My Objects Details",
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
                    modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
                    item = MyObjectData(
                        propertyName = "Property 1",
                        propertyAddress = "vijay nagar near krishna doodh dairy",
                        id = 1
                    ),
                    onDetailsClick = {
//                        navController.popBackStack()
//                        navController.navigate(MyObjectDetailsScreen)
                    },
                    onInviteClick = {
                        navController.popBackStack()
                        navController.navigate(MyObjectInviteAFriendScreen)
                    },
                    onReportsClick = {
                        navController.popBackStack()
                        navController.navigate(MyObjectReportsAndNotificationScreen)
                    },
                    onMySeismoconClick = {
                        navController.popBackStack()
                        navController.navigate(MySeismoconScreen)
                    })

                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(color = LightBlue2, shape = RoundedCornerShape(12.dp))
                ) {
                    Text(
                        "Building Data-Property ID 123 123",
                        color = Color.White,
                        modifier = Modifier.padding(
                            top = 15.dp
                        ).padding(horizontal = 20.dp),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_semibold))
                    )

                    Spacer(Modifier.height(10.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth().background(
                                color = LightBlue, shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 0.dp,
                                    bottomStart = 12.dp,
                                    bottomEnd = 12.dp
                                )
                            )
                    ) {
                        items.forEachIndexed { index, item ->
                            MyObjectDetailsTextItems(item)

                            if (index < items.size - 1) {
                                Box(
                                    modifier = Modifier.padding(top = 10.dp).height(1.dp)
                                        .fillMaxWidth().background(color = White10Per)
                                )
                            } else {
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}