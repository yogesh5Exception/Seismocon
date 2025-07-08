package com.fiveexceptions.seismocon.core.commonComposables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.img_seismocon

@Composable
fun AppIconImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(Res.drawable.img_seismocon),
        contentDescription = "seismocon",
        modifier = modifier
    )
}