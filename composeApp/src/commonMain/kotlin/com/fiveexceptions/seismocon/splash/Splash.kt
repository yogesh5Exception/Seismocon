package com.fiveexceptions.seismocon.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.ui.DarkBlue
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.img_main_bg

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize().background(color = DarkBlue)) {
            Image(
                painter = painterResource(Res.drawable.img_main_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            AppIconImage(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp).heightIn(120.dp)
                    .align(Alignment.Center),
            )
        }
    }
}