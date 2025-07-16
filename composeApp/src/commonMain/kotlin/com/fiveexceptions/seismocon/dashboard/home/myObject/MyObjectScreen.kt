package com.fiveexceptions.seismocon.dashboard.home.myObject

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.dashboard.home.myObject.data.MyObjectData
import com.fiveexceptions.seismocon.navigation.MyObjectDetailsScreen
import com.fiveexceptions.seismocon.navigation.MyObjectInviteAFriendScreen
import com.fiveexceptions.seismocon.navigation.MyObjectReportsAndNotificationScreen
import com.fiveexceptions.seismocon.navigation.MySeismoconScreen
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.Gray
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color

@Composable
@Preview
fun MyObjectScreen(navController: NavController) {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {

            Column(
                modifier = Modifier.fillMaxSize().padding(top = 26.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppIconImage(
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                        .padding(horizontal = 40.dp).heightIn(90.dp)
                )

                Box(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                        .padding(top = 20.dp)
                ) {
                    LabelText(
                        text = "My Objects",
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

                val listOfItems = listOf(
                    MyObjectData(
                        propertyName = "Property 1",
                        propertyAddress = "vijay nagar near krishna doodh dairy",
                        id = 1
                    ), MyObjectData(
                        propertyName = "Property 2",
                        propertyAddress = "Radisson chauraha near malviya petrol pump",
                        id = 2
                    ), MyObjectData(
                        propertyName = "Property 3",
                        propertyAddress = "vijay nagar near krishna doodh dairy",
                        id = 3
                    ), MyObjectData(
                        propertyName = "Property 4",
                        propertyAddress = "Radisson chauraha near malviya petrol pump",
                        id = 4
                    )
                )

                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
                    contentPadding = PaddingValues(vertical = 30.dp)
                ) {
                    items(listOfItems) {
                        MyObjectItem(
                            modifier = Modifier.fillMaxWidth(),
                            item = it,
                            onDetailsClick = {
                                navController.navigate(MyObjectDetailsScreen)
                            },
                            onInviteClick = {
                                navController.navigate(MyObjectInviteAFriendScreen)
                            },
                            onReportsClick = {
                                navController.navigate(MyObjectReportsAndNotificationScreen)
                            },
                            onMySeismoconClick = {
                                navController.navigate(MySeismoconScreen)
                            })
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}