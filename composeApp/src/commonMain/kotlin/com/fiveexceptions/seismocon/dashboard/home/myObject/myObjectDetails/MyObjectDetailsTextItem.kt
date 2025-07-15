package com.fiveexceptions.seismocon.dashboard.home.myObject.myObjectDetails

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.Font
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.inter_medium
import seismocon.composeapp.generated.resources.inter_semibold

@Composable
fun MyObjectDetailsTextItems(item: MyObjectDetailsData) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).padding(top = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            item.key,
            color = Color.White,
            modifier = Modifier.padding(end = 20.dp),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(Res.font.inter_medium)),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start
        )

        Text(
            item.value,
            color = Color.White,
            modifier = Modifier.weight(1f).padding(start = 20.dp),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(Res.font.inter_semibold)),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.End
        )
    }
}