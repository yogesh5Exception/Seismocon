package com.fiveexceptions.seismocon.dashboard.home.myObject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fiveexceptions.seismocon.dashboard.home.myObject.data.MyObjectData
import com.fiveexceptions.seismocon.ui.DarkBlue2
import com.fiveexceptions.seismocon.ui.LightBlue
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_delete
import seismocon.composeapp.generated.resources.img_object
import seismocon.composeapp.generated.resources.inter_medium
import seismocon.composeapp.generated.resources.inter_semibold

@Composable
fun MyObjectItem(
    item: MyObjectData,
    modifier: Modifier,
    onDetailsClick: () -> Unit,
    onReportsClick: () -> Unit,
    onInviteClick: () -> Unit,
    onMySeismoconClick: () -> Unit
) {
    Column(
        modifier = modifier.border(
            width = 1.dp, color = Color.White, shape = RoundedCornerShape(12.dp)
        ).background(color = DarkBlue2, shape = RoundedCornerShape(12.dp))
    ) {
        Text(
            "${item.propertyName}:",
            color = Color.White,
            modifier = Modifier.padding(
                top = 15.dp, start = 16.dp, end = 16.dp
            ),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(Res.font.inter_semibold))
        )

        Text(
            item.propertyAddress,
            color = Color.White,
            modifier = Modifier.padding(
                top = 5.dp, start = 16.dp, end = 16.dp
            ),
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(Res.font.inter_medium))
        )

        Spacer(Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(color = Color.White))
        Column(
            modifier = Modifier.fillMaxWidth().background(
                color = LightBlue, shape = RoundedCornerShape(
                    topStart = 0.dp, topEnd = 0.dp, bottomStart = 12.dp, bottomEnd = 12.dp
                )
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painterResource(Res.drawable.img_object),
                    contentDescription = "",
                    modifier = Modifier.height(100.dp).width(75.dp).clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier, verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        MyObjectItemButton(
                            title = "Details",
                            modifier = Modifier.fillMaxWidth().weight(1f),
                            onClick = onDetailsClick
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        MyObjectItemButton(
                            title = "My Seismocon",
                            modifier = Modifier.fillMaxWidth().weight(1f),
                            onClick = onMySeismoconClick
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        MyObjectItemButton(
                            title = "Reports",
                            modifier = Modifier.fillMaxWidth().weight(1f),
                            onClick = onReportsClick
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        MyObjectItemButton(
                            title = "Invite a Friend",
                            modifier = Modifier.fillMaxWidth().weight(1f),
                            onClick = onInviteClick
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.End).padding(end = 20.dp)
                    .clickable(onClick = {})
            ) {
                Icon(
                    painterResource(Res.drawable.ic_delete),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Delete",
                    style = MaterialTheme.typography.labelLarge,
                    fontFamily = FontFamily(Font(Res.font.inter_medium)),
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}