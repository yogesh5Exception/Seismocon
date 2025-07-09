package com.fiveexceptions.seismocon.dashboard.home.allSensorsNow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.patrykandpatrick.vico.multiplatform.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.multiplatform.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.multiplatform.cartesian.data.lineSeries
import com.patrykandpatrick.vico.multiplatform.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.multiplatform.cartesian.rememberCartesianChart
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SensorItem() {
    val modelProducer = remember { CartesianChartModelProducer() }
    LaunchedEffect(Unit) {
        modelProducer.runTransaction {
            lineSeries {
                series(
                    13,
                    8,
                    7,
                    12,
                    0,
                    1,
                    15,
                    14,
                    0,
                    11,
                    6,
                    0,
                    11,
                    12,
                    12,
                    32,
                    23,
                    23,
                    4,
                    12
                )
            }
        }
    }

    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp))
    {
        CartesianChartHost(
            chart =
                rememberCartesianChart(
                    rememberLineCartesianLayer()
                    /*, startAxis = VerticalAxis.rememberStart(),
                    bottomAxis = HorizontalAxis.rememberBottom(),*/
                ),
            modelProducer = modelProducer,
            modifier = Modifier.fillMaxWidth().height(120.dp),
        )

        Row(
            modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


        }
    }
}