package com.fiveexceptions.seismocon.dashboard.home.commonComposables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fiveexceptions.seismocon.ui.LightGray

@Composable
fun HomeCard(
    title: String,
    titleColor: Color,
    content: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.background(color = LightGray, shape = RoundedCornerShape(12.dp))) {

        Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
            Text(text = title, color = titleColor, style = MaterialTheme.typography.titleMedium)
            content?.let {
                Spacer(modifier = Modifier.height(16.dp))
                it.invoke()
            }
        }
    }
}