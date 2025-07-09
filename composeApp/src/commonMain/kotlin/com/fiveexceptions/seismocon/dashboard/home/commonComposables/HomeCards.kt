package com.fiveexceptions.seismocon.dashboard.home.commonComposables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.fiveexceptions.seismocon.ui.LightGray
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeCard(
    title: String,
    titleColor: Color,
    content: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier,
    bgImage: DrawableResource? = null
) {
    Box(modifier = modifier.background(color = LightGray, shape = RoundedCornerShape(12.dp))) {
        bgImage?.let {
            Image(
                painterResource(it),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().heightIn(min = 150.dp, max = 150.dp)
                    .clip(RoundedCornerShape(size = 12.dp))
            )
        }
        Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
            Text(text = title, color = titleColor, style = MaterialTheme.typography.titleMedium)
            content?.let {
                Spacer(modifier = Modifier.height(16.dp))
                it.invoke()
            }
        }
    }
}