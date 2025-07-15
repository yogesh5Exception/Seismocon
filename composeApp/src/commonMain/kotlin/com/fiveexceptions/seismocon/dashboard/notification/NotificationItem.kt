package com.fiveexceptions.seismocon.dashboard.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fiveexceptions.seismocon.ui.White10Per
import org.jetbrains.compose.resources.Font
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.inter_regular
import seismocon.composeapp.generated.resources.inter_semibold

@Composable
fun NotificationItem(notification: NotificationData) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(color = White10Per))

        Text(
            text = notification.date,
            color = Color.White,
            modifier = Modifier.fillMaxWidth().padding(top = 20.dp).padding(horizontal = 20.dp),
            textAlign = TextAlign.Start,
            fontFamily = FontFamily(Font(Res.font.inter_semibold)),
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = notification.message,
            color = Color.White,
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp).padding(horizontal = 20.dp)
                .padding(bottom = 20.dp),
            textAlign = TextAlign.Start,
            fontFamily = FontFamily(Font(Res.font.inter_regular)),
            style = MaterialTheme.typography.labelMedium
        )
    }
}