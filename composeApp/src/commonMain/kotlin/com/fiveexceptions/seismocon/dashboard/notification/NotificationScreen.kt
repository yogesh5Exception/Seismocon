package com.fiveexceptions.seismocon.dashboard.notification

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.core.commonComposables.popSafeBack
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.Gray
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color

@Composable
@Preview
fun NotificationScreen(navController: NavController) {

    val items: List<NotificationData> = listOf(
        NotificationData(
            "08-06-2024",
            "We have an update 08-12-2024. The system will be down for 2 hours etc."
        ),
        NotificationData(
            "09-06-2024",
            "M.4 earthquake happened in xxxxx at 4.55 am. This is 125 miles from your home."
        ),
        NotificationData(
            "10-06-2024",
            "We have an update 08-12-2024. The system will be down for 2 hours etc."
        ),
        NotificationData(
            "11-06-2024",
            "M.4 earthquake happened in xxxxx at 4.55 am. This is 125 miles from your home."
        ),
        NotificationData(
            "12-06-2024",
            "We have an update 08-12-2024. The system will be down for 2 hours etc."
        ),
        NotificationData(
            "13-06-2024",
            "M.4 earthquake happened in xxxxx at 4.55 am. This is 125 miles from your home."
        ), NotificationData(
            "14-06-2024",
            "We have an update 08-12-2024. The system will be down for 2 hours etc."
        ),
        NotificationData(
            "15-06-2024",
            "M.4 earthquake happened in xxxxx at 4.55 am. This is 125 miles from your home."
        ),
        NotificationData(
            "16-06-2024",
            "We have an update 08-12-2024. The system will be down for 2 hours etc."
        ),
        NotificationData(
            "17-06-2024",
            "M.4 earthquake happened in xxxxx at 4.55 am. This is 125 miles from your home."
        ),
        NotificationData(
            "18-06-2024",
            "We have an update 08-12-2024. The system will be down for 2 hours etc."
        ),
        NotificationData(
            "19-06-2024",
            "M.4 earthquake happened in xxxxx at 4.55 am. This is 125 miles from your home."
        )
    )

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
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                        .padding(horizontal = 20.dp)
                ) {
                    LabelText(
                        text = "Notification",
                        modifier = Modifier.fillMaxWidth().align(Alignment.Center),
                        textStyle = MaterialTheme.typography.titleMedium
                    )

                    Box(
                        modifier = Modifier.size(36.dp).border(
                            width = 1.dp, color = Gray, shape = RoundedCornerShape(8.dp)
                        ).padding(6.dp).clickable(
                            onClick = {
                                navController.popSafeBack()
                            }
                        )
                            .align(Alignment.CenterStart)
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_back_white_color),
                            contentDescription = "Go back",
                            tint = Color.White,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                LazyColumn(
                    contentPadding = PaddingValues(vertical = 20.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(items) { item ->
                        NotificationItem(item)
                    }
                }
            }
        }
    }
}