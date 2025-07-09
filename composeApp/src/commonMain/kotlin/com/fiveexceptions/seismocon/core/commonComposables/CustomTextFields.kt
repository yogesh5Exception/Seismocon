package com.fiveexceptions.seismocon.core.commonComposables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiveexceptions.seismocon.ui.White30Per
import org.jetbrains.compose.resources.Font
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.inter_regular


@Composable
fun TextFieldWithLeadingIcon(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: Painter,
    modifier: Modifier = Modifier,
    iconBgPadding: Dp = 10.dp
) {
    Box(
        modifier = modifier.border(
            width = 1.dp, color = Color.White, shape = RoundedCornerShape(3.dp)
        ).clip(RoundedCornerShape(3.dp))
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = leadingIcon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(
                        start = 8.dp,
                        end = 10.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
                        .background(color = White30Per, shape = RoundedCornerShape(2.dp))
                        .padding(iconBgPadding)
                )
            },
            placeholder = {
                Text(text = placeholder, color = Color.White)
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White
            ),
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(Res.font.inter_regular)),
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp, // optional
            ),
            singleLine = true
        )
    }
}