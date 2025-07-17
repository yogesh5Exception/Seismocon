package com.fiveexceptions.seismocon.dashboard.home.mySeismocon

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.dashboard.home.myObject.myObjectReportsAndNotification.MyObjectNotificationData
import com.fiveexceptions.seismocon.dashboard.home.myObject.myObjectReportsAndNotification.MyObjectReportData
import com.fiveexceptions.seismocon.ui.Blue
import com.fiveexceptions.seismocon.ui.DarkBlue2
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.Gray
import com.fiveexceptions.seismocon.ui.LightBlue
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color
import seismocon.composeapp.generated.resources.ic_delete
import seismocon.composeapp.generated.resources.img_my_seismocon2
import seismocon.composeapp.generated.resources.inter_medium
import seismocon.composeapp.generated.resources.inter_regular
import seismocon.composeapp.generated.resources.inter_semibold

@Composable
@Preview
fun MySeismoconScreen(navController: NavController) {
    val reports: List<MyObjectReportData> = listOf(
        MyObjectReportData("1231232", "Taxonomy", "03/23/2025", true, 1),
        MyObjectReportData("1231234", "Survey", "03/25/2025", false, 3)
    )

    val notifications: List<MyObjectNotificationData> = listOf(
        MyObjectNotificationData(
            notificationId = "456446", date = "03/03/25", isShowingDeleteButton = false, id = 1
        ), MyObjectNotificationData(
            notificationId = "456446", date = "03/03/25", isShowingDeleteButton = true, id = 2
        )
    )

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {

            Column(
                modifier = Modifier.fillMaxSize().padding(top = 26.dp)
                    .padding(start = 20.dp, end = 20.dp).verticalScroll(
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
                        text = "My Seismocon",
                        modifier = Modifier.fillMaxWidth().align(Alignment.Center),
                        textStyle = MaterialTheme.typography.titleMedium
                    )

                    Box(
                        modifier = Modifier.size(36.dp).border(
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

                Column(
                    modifier = Modifier.fillMaxWidth().padding(top = 30.dp).border(
                        width = 1.dp, color = Color.White, shape = RoundedCornerShape(12.dp)
                    ).background(color = DarkBlue2, shape = RoundedCornerShape(12.dp))
                ) {
                    Text(
                        "356 Preston Avenue, Santa Rose, CA 95668",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth().padding(
                            top = 15.dp, start = 16.dp, end = 16.dp
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
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

                        Image(
                            painterResource(Res.drawable.img_my_seismocon2),
                            contentDescription = null,
                            modifier = Modifier.height(140.dp).fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "Monitoring Units  [MU]",
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            style = MaterialTheme.typography.bodyMedium,
                            fontFamily = FontFamily(Font(Res.font.inter_semibold)),
                            modifier = Modifier.fillMaxWidth().background(color = Color.White)
                                .padding(vertical = 6.dp)
                        )

                        val listOfItems = listOf(
                            MySeismoconMonitoringUnitData(
                                name = "Living Room", id = 1
                            ), MySeismoconMonitoringUnitData(name = "Bed Room", id = 2)
                        )
                        Column {
                            listOfItems.forEach { d ->
                                MyObjectMySeismoconMonitoringUnitItem(item = d)
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Add Monitoring Unit",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color.White,
                                    shape = RoundedCornerShape(6.dp)
                                ).padding(10.dp).align(Alignment.CenterHorizontally),
                            style = MaterialTheme.typography.bodyMedium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }

                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}

@Composable
fun MyObjectMySeismoconMonitoringUnitItem(item: MySeismoconMonitoringUnitData) {
    Row(
        modifier = Modifier.padding(top = 10.dp).fillMaxWidth().padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = item.name,
            textAlign = TextAlign.Start,
            color = Color.White,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = FontFamily(Font(Res.font.inter_medium)),
        )

        if (item.isSensorButtonVisible) {
            Text(
                text = "Sensors",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.background(
                    Blue, shape = RoundedCornerShape(4.dp)
                ).padding(horizontal = 8.dp).padding(vertical = 5.dp),
                fontFamily = FontFamily(Font(Res.font.inter_regular)),
            )
        }

        if (item.isAboutButtonVisible) {
            Text(
                text = "About",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.background(
                    Blue, shape = RoundedCornerShape(4.dp)
                ).padding(horizontal = 8.dp).padding(vertical = 5.dp),
                fontFamily = FontFamily(Font(Res.font.inter_regular)),
            )
        }

        if (item.isDeleteButtonVisible) {
            Icon(
                painterResource(Res.drawable.ic_delete),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.padding(start = 10.dp).size(20.dp)
            )
        }
    }

}