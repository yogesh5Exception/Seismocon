package com.fiveexceptions.seismocon.core.commonComposables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fiveexceptions.seismocon.ui.Blue
import org.jetbrains.compose.resources.Font
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.inter_semibold

@Composable
fun CommonButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = Blue,
    cornerRadius: Dp = 12.dp,
    horizontalContentPadding: Dp = 0.dp,
    verticalContentPadding: Dp = 14.dp
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor
        ),
        shape = RoundedCornerShape(cornerRadius),
        contentPadding = PaddingValues(
            horizontal = horizontalContentPadding,
            vertical = verticalContentPadding
        )
    ) {
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(Res.font.inter_semibold))
        )
    }
}
