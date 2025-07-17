package com.fiveexceptions.seismocon.dashboard.home.mySeismocon.allSensorsNow.lidar

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.ui.Blue2
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.Gray
import com.fiveexceptions.seismocon.ui.GreenBrighter
import com.fiveexceptions.seismocon.ui.LightBlue
import com.fiveexceptions.seismocon.ui.White20Per
import com.fiveexceptions.seismocon.ui.White30Per
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color
import seismocon.composeapp.generated.resources.inter_medium
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun LidarScreen(navController: NavController) {

    var currentValue by remember { mutableIntStateOf(0) }
    val animatedValue = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        while (true) {
            animatedValue.animateTo(
                targetValue = 100f, animationSpec = tween(
                    durationMillis = 100 * (100 - currentValue), // sweep speed per value
                    easing = LinearEasing
                )
            )
            animatedValue.snapTo(0f)
        }
    }

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.fillMaxSize().padding(top = 26.dp).padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState()),
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
                        text = "Lidar",
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

                Text(
                    "LIDAR measures distances within your room and is also used for placement & displacement control",
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth().padding(top = 30.dp),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(Res.font.inter_medium))
                )

                Column(
                    modifier = Modifier.padding(top = 30.dp).fillMaxWidth()
                        .background(color = LightBlue, shape = RoundedCornerShape(12.dp))
                        .padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "Normal",
                        color = GreenBrighter,
                        modifier = Modifier.align(Alignment.Start),
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                    Text(
                        "LiDAR",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                    LidarGauge(
                        modifier = Modifier.padding(top = 20.dp).size(200.dp),
                        inputValue = animatedValue.value.toInt(),
                        progressColors = listOf(Color.Green, Color.Yellow, Color.Red),
                        innerGradient = Color.LightGray,
                        percentageColor = Color.White
                    )
                }

                Column(
                    modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                        .background(color = LightBlue, shape = RoundedCornerShape(12.dp))
                        .padding(vertical = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Threshold value",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                    Row(
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Millimeter",
                            modifier = Modifier.weight(0.5f)
                                .background(color = White20Per, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "+/- 20",
                            modifier = Modifier.weight(0.5f)
                                .background(color = White20Per, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )
                    }

                    Text(
                        "Units",
                        color = Color.White,
                        modifier = Modifier.padding(top = 20.dp),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                    Row(
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Inches",
                            modifier = Modifier.weight(0.5f)
                                .background(color = White20Per, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "Centimeters",
                            modifier = Modifier.weight(0.5f)
                                .background(color = White20Per, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )
                    }

                    Text(
                        "605.80 cm",
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .background(color = White20Per, shape = RoundedCornerShape(3.dp))
                            .border(
                                width = 1.dp,
                                color = White30Per,
                                shape = RoundedCornerShape(3.dp)
                            ).padding(horizontal = 10.dp, vertical = 6.dp),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                    Row(
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            "1Hr",
                            modifier = Modifier.weight(0.2f)
                                .background(color = Blue2, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Text(
                            "1Day",
                            modifier = Modifier.weight(0.2f)
                                .background(color = Blue2, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Text(
                            "1Mon",
                            modifier = Modifier.weight(0.2f)
                                .background(color = Blue2, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Text(
                            "6Mon",
                            modifier = Modifier.weight(0.2f)
                                .background(color = Blue2, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Text(
                            "1Yr",
                            modifier = Modifier.weight(0.2f)
                                .background(color = Blue2, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )
                    }

                    Text(
                        "HighLow Value - Moving Average",
                        modifier = Modifier.padding(top = 10.dp).fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .background(color = Blue2, shape = RoundedCornerShape(3.dp))
                            .border(
                                width = 1.dp,
                                color = White30Per,
                                shape = RoundedCornerShape(3.dp)
                            ).padding(horizontal = 10.dp, vertical = 6.dp),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium))
                    )

                    Row(
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Average",
                            modifier = Modifier.weight(0.5f)
                                .background(color = Blue2, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "605.72",
                            modifier = Modifier.weight(0.5f)
                                .background(color = White20Per, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )
                    }

                    Row(
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "High",
                            modifier = Modifier.weight(0.5f)
                                .background(color = Blue2, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "606.72",
                            modifier = Modifier.weight(0.5f)
                                .background(color = White20Per, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )
                    }

                    Row(
                        modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            "Low",
                            modifier = Modifier.weight(0.5f)
                                .background(color = Blue2, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            "604.72",
                            modifier = Modifier.weight(0.5f)
                                .background(color = White20Per, shape = RoundedCornerShape(3.dp))
                                .border(
                                    width = 1.dp,
                                    color = White30Per,
                                    shape = RoundedCornerShape(3.dp)
                                ).padding(horizontal = 10.dp, vertical = 6.dp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )
                    }
                }
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}


@Composable
fun LidarGauge(
    modifier: Modifier = Modifier,
    inputValue: Int,
    trackColor: Color = Color(0xFFE0E0E0),
    progressColors: List<Color>,
    innerGradient: Color,
    percentageColor: Color = Color.White
) {

    val meterValue = getMeterValue(inputValue)
    Box(modifier = modifier.size(196.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val sweepAngle = 240f
            val fillSwipeAngle = (meterValue / 100f) * sweepAngle
            val height = size.height
            val width = size.width
            val startAngle = 150f
            val arcHeight = height - 20.dp.toPx()

            drawArc(
                color = trackColor,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = Offset((width - height + 60f) / 2f, (height - arcHeight) / 2f),
                size = Size(arcHeight, arcHeight),
                style = Stroke(width = 50f, cap = StrokeCap.Round)
            )

            drawArc(
                brush = Brush.horizontalGradient(progressColors),
                startAngle = startAngle,
                sweepAngle = fillSwipeAngle,
                useCenter = false,
                topLeft = Offset((width - height + 60f) / 2f, (height - arcHeight) / 2),
                size = Size(arcHeight, arcHeight),
                style = Stroke(width = 50f, cap = StrokeCap.Round)
            )
            val centerOffset = Offset(width / 2f, height / 2.09f)
            drawCircle(
                Brush.radialGradient(
                    listOf(
                        innerGradient.copy(alpha = 0.2f), Color.Transparent
                    )
                ), width / 2f
            )
            drawCircle(Color.White, 24f, centerOffset)

            // Calculate needle angle based on inputValue
            val needleAngle = (meterValue / 100f) * sweepAngle + startAngle
            val needleLength = 160f // Adjust this value to control needle length
            val needleBaseWidth = 10f // Adjust this value to control the base width


            val needlePath = Path().apply {
                fun toRadians(degrees: Float): Float = (degrees * PI / 180).toFloat()

                // Calculate the top point of the needle
                val topX = centerOffset.x + needleLength * cos(toRadians(needleAngle))
                val topY = centerOffset.y + needleLength * sin(toRadians(needleAngle))

                // Calculate the base points of the needle
                val baseLeftX = centerOffset.x + needleBaseWidth * cos(toRadians(needleAngle - 90))
                val baseLeftY = centerOffset.y + needleBaseWidth * sin(toRadians(needleAngle - 90))
                val baseRightX = centerOffset.x + needleBaseWidth * cos(toRadians(needleAngle + 90))
                val baseRightY = centerOffset.y + needleBaseWidth * sin(toRadians(needleAngle + 90))

                moveTo(topX, topY)
                lineTo(baseLeftX, baseLeftY)
                lineTo(baseRightX, baseRightY)
                close()
            }


            drawPath(
                color = Color.White, path = needlePath
            )
        }

        Column(
            modifier = Modifier.padding(bottom = 5.dp).align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$inputValue %",
                fontSize = 20.sp,
                lineHeight = 28.sp,
                color = percentageColor
            )
            Text(
                text = "Percentage", fontSize = 16.sp, lineHeight = 24.sp, color = Color(0xFFB0B4CD)
            )
        }

    }
}

private fun getMeterValue(inputPercentage: Int): Int {
    return if (inputPercentage < 0) {
        0
    } else if (inputPercentage > 100) {
        100
    } else {
        inputPercentage
    }
}