package com.fiveexceptions.seismocon.dashboard.home.mySeismocon.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.ui.Blue
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.Gray
import com.fiveexceptions.seismocon.ui.White10Per
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color
import seismocon.composeapp.generated.resources.ic_edit
import seismocon.composeapp.generated.resources.img_seismocon2
import seismocon.composeapp.generated.resources.inter_medium
import seismocon.composeapp.generated.resources.inter_regular
import seismocon.composeapp.generated.resources.inter_semibold

@Composable
fun AboutMySeismoconScreen(navController: NavController) {

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.fillMaxSize().padding(top = 26.dp).padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppIconImage(
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                        .padding(horizontal = 20.dp).heightIn(90.dp)
                )

                Box(
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                ) {
                    LabelText(
                        text = "My Seismocon",
                        modifier = Modifier.fillMaxWidth().align(Alignment.Center),
                        textStyle = MaterialTheme.typography.titleMedium
                    )

                    Box(
                        modifier = Modifier.size(36.dp).border(
                            width = 1.dp, color = Gray, shape = RoundedCornerShape(8.dp)
                        ).padding(6.dp).clickable(onClick = { navController.popBackStack() })
                            .align(Alignment.CenterStart)
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_back_white_color),
                            contentDescription = "Go back",
                            tint = Color.White,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                Column(
                    modifier = Modifier.padding(top = 30.dp).fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {

                    Image(
                        painterResource(Res.drawable.img_seismocon2),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().height(200.dp),
                        contentScale = ContentScale.Crop
                    )

                    Row(
                        modifier = Modifier.padding(top = 30.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Monitoring Unit:",
                            modifier = Modifier.weight(0.5f),
                            color = Color.White,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "Living Room",
                            modifier = Modifier.weight(0.5f),
                            color = Color.White,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )
                    }

                    Row(
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "8502 Preston Rd.",
                            modifier = Modifier.weight(1f),
                            color = Color.White,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily(Font(Res.font.inter_semibold))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Row(
                            modifier = Modifier.background(
                                color = Blue,
                                shape = RoundedCornerShape(6.dp)
                            ).clickable(onClick = {}).padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.ic_edit),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(12.dp)
                            )
                            Text(
                                "Edit",
                                color = Color.White,
                                modifier = Modifier.padding(start = 4.dp),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily(Font(Res.font.inter_medium))
                            )
                        }
                    }

                    Text(
                        "Inglewood Maine 98380",
                        modifier = Modifier,
                        color = Color.White,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                    Box(
                        modifier = Modifier.padding(top = 30.dp).fillMaxWidth().height(1.dp)
                            .background(color = White10Per)
                    )

                    Row(
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Latitude:",
                            modifier = Modifier,
                            color = Color.White,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily(Font(Res.font.inter_semibold))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "38.3280152",
                            modifier = Modifier.weight(1f),
                            color = Color.White,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_regular))
                        )
                    }

                    Row(
                        modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Longitude:",
                            modifier = Modifier,
                            color = Color.White,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily(Font(Res.font.inter_semibold))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "-122.2999205",
                            modifier = Modifier.weight(1f),
                            color = Color.White,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_regular))
                        )
                    }

                    Box(
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth().height(1.dp)
                            .background(color = White10Per)
                    )

                    Row(
                        modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Unit ID",
                            modifier = Modifier,
                            color = Color.White,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily(Font(Res.font.inter_semibold))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "12312312",
                            modifier = Modifier.weight(1f),
                            color = Color.White,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_regular))
                        )
                    }

                    Row(
                        modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Install Date",
                            modifier = Modifier,
                            color = Color.White,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily(Font(Res.font.inter_semibold))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "Aug 24, 2024",
                            modifier = Modifier.weight(1f),
                            color = Color.White,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_regular))
                        )
                    }

                    Row(
                        modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Serial No.:",
                            modifier = Modifier,
                            color = Color.White,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily(Font(Res.font.inter_semibold))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "1231231",
                            modifier = Modifier.weight(1f),
                            color = Color.White,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(Res.font.inter_regular))
                        )
                    }

                    Box(
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth().height(1.dp)
                            .background(color = White10Per)
                    )

                    Spacer(modifier = Modifier.height(50.dp))
                }
            }
        }
    }
}
