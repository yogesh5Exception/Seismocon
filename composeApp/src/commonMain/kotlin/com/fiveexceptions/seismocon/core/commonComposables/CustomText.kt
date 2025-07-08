package com.fiveexceptions.seismocon.core.commonComposables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.resources.Font
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.inter_semibold

@Composable
fun LabelText(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.titleLarge
) {
    Text(
        text = text, modifier = modifier,
        color = Color.White,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily(Font(Res.font.inter_semibold)),
        style = textStyle,
        textAlign = TextAlign.Center
    )
}
