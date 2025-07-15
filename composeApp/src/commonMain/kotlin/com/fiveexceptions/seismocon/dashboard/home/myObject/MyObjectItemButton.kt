package com.fiveexceptions.seismocon.dashboard.home.myObject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fiveexceptions.seismocon.ui.DarkBlue2
import org.jetbrains.compose.resources.Font
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.inter_medium

@Composable
fun MyObjectItemButton(title: String, modifier: Modifier, onClick: () -> Unit) {
    Text(
        title,
        modifier = modifier.background(color = DarkBlue2, shape = RoundedCornerShape(4.dp))
            .padding(vertical = 6.dp).padding(horizontal = 5.dp)
            .clickable(onClick = { onClick() }),
        color = Color.White,
        style = MaterialTheme.typography.labelMedium,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(Res.font.inter_medium))
    )
}