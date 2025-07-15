package com.fiveexceptions.seismocon.dashboard.home

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.dashboard.home.commonComposables.HomeCard
import com.fiveexceptions.seismocon.navigation.EarthquakesNowScreen
import com.fiveexceptions.seismocon.navigation.MyObjectScreen
import com.fiveexceptions.seismocon.navigation.MySeismoconScreen
import com.fiveexceptions.seismocon.navigation.ScienceScreen
import com.fiveexceptions.seismocon.navigation.TechnologyScreen
import com.fiveexceptions.seismocon.ui.DarkBlue
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.Gray
import com.fiveexceptions.seismocon.ui.Green
import org.jetbrains.compose.resources.Font
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.img_earthquakes_now
import seismocon.composeapp.generated.resources.img_my_object
import seismocon.composeapp.generated.resources.img_my_seismocon
import seismocon.composeapp.generated.resources.img_science
import seismocon.composeapp.generated.resources.img_technology
import seismocon.composeapp.generated.resources.inter_regular
import seismocon.composeapp.generated.resources.inter_semibold
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {

    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize().background(color = DarkBlue)) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
            )

            Column(
                modifier = modifier.verticalScroll(rememberScrollState())
                    .padding(top = 26.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppIconImage(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 40.dp).heightIn(90.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 40.dp)
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    LabelText(
                        text = "Home",
                        modifier = Modifier,
                        textStyle = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        "Hello John",
                        fontFamily = FontFamily(Font(Res.font.inter_semibold)),
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.background(
                            color = Gray, shape = RoundedCornerShape(16.dp)
                        ).padding(horizontal = 23.dp).padding(vertical = 4.dp)
                    )
                }

                HomeCard(
                    title = "Messages", titleColor = Color.Black,
                    content = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                "No alerts reported",
                                color = Color.Black,
                                fontFamily = FontFamily(Font(Res.font.inter_regular)),
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    },
                    modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                        .padding(horizontal = 20.dp), navController = navController
                )

                HomeCard(
                    title = "My Object",
                    titleColor = Color.White,
                    bgImage = Res.drawable.img_my_object,
                    modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    onClick = { navController.navigate(MyObjectScreen) },
                    navController = navController
                )

                HomeCard(
                    title = "My Seismocon",
                    titleColor = Color.Black,
                    bgImage = Res.drawable.img_my_seismocon,
                    modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    content = {
                        Column {
                            Spacer(modifier = Modifier.height(32.dp))

                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(color = Color.Black)) {
                                        append("Motor Unit ")
                                    }
                                    withStyle(style = SpanStyle(color = Green)) {
                                        append("On")
                                    }
                                },
                                fontFamily = FontFamily(Font(Res.font.inter_regular)),
                                style = MaterialTheme.typography.titleSmall,
                            )
                        }
                    }, onClick = {
                        navController.navigate(MySeismoconScreen)
                    }, navController = navController
                )


                Row(modifier = Modifier.fillMaxWidth().padding(top = 20.dp)) {

                    HomeCard(
                        title = "Technology",
                        titleColor = Color.White,
                        bgImage = Res.drawable.img_technology,
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 20.dp).weight(1f),
                        onClick = {
                            navController.navigate(TechnologyScreen)
                        }, navController = navController
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    HomeCard(
                        title = "Earthquakes Now",
                        titleColor = Color.White,
                        bgImage = Res.drawable.img_earthquakes_now,
                        modifier = Modifier.fillMaxWidth()
                            .padding(end = 20.dp).weight(1f),
                        onClick = {
                            navController.navigate(EarthquakesNowScreen)
                        }, navController = navController
                    )
                }

                HomeCard(
                    title = "Science",
                    titleColor = Color.White,
                    bgImage = Res.drawable.img_science,
                    modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                        .padding(horizontal = 20.dp), onClick = {
                        navController.navigate(ScienceScreen)
                    }, navController = navController
                )

                Spacer(Modifier.height(50.dp))
            }
        }
    }
}

fun Modifier.gradientBackground(colors: List<Color>, angle: Float) = this.then(
    Modifier.drawBehind {

        // Setting the angle in radians
        val angleRad = angle / 180f * PI

        // Fractional x
        val x = kotlin.math.cos(angleRad).toFloat()

        // Fractional y
        val y = kotlin.math.sin(angleRad).toFloat()

        // Set the Radius and offset as shown below
        val radius = sqrt(size.width.pow(2) + size.height.pow(2)) / 2f
        val offset = center + Offset(x * radius, y * radius)

        // Setting the exact offset
        val exactOffset = Offset(
            x = kotlin.math.min(offset.x.coerceAtLeast(0f), size.width),
            y = size.height - kotlin.math.min(offset.y.coerceAtLeast(0f), size.height)
        )

        // Draw a rectangle with the above values
        drawRect(
            brush = Brush.linearGradient(
                colors = colors,
                start = Offset(size.width, size.height) - exactOffset,
                end = exactOffset
            ), size = size
        )
    })