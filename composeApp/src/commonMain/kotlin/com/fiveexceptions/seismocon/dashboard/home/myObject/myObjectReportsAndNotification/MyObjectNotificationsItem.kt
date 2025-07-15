package com.fiveexceptions.seismocon.dashboard.home.myObject.myObjectReportsAndNotification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.fiveexceptions.seismocon.ui.White10Per
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_delete
import seismocon.composeapp.generated.resources.inter_regular

@Composable
fun MyObjectNotificationItem(
    modifier: Modifier = Modifier,
    fontFamily: FontFamily = FontFamily(Font(Res.font.inter_regular)),
    item: MyObjectNotificationData,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    fontWeight: FontWeight = FontWeight.Normal,
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            item.notificationId,
            color = Color.White,
            modifier = modifier.weight(0.5f).padding(top = 8.dp).padding(bottom = 8.dp),
            style = textStyle,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start
        )

        Box(modifier = Modifier.fillMaxHeight().width(1.dp).background(color = White10Per))

        Text(
            item.date,
            color = Color.White,
            modifier = modifier.weight(0.5f).padding(start = 10.dp).padding(end = 10.dp)
                .padding(top = 8.dp)
                .padding(bottom = 8.dp),
            style = textStyle,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start
        )

        if (item.isShowingDeleteButton) {
            Icon(
                painterResource(Res.drawable.ic_delete),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.padding(start = 8.dp).padding(top = 8.dp)
                    .padding(bottom = 8.dp)
                    .size(16.dp)
            )
        } else {
            Spacer(
                modifier = Modifier.padding(start = 8.dp).padding(top = 8.dp)
                    .padding(bottom = 8.dp)
                    .size(16.dp)
            )
        }
    }
}