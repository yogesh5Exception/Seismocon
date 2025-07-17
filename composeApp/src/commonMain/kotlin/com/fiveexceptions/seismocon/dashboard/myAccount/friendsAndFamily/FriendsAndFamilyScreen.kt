package com.fiveexceptions.seismocon.dashboard.myAccount.friendsAndFamily

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.ui.Blue
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.Gray
import com.fiveexceptions.seismocon.ui.LightBlue
import com.fiveexceptions.seismocon.ui.White20Per
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color
import seismocon.composeapp.generated.resources.ic_delete
import seismocon.composeapp.generated.resources.inter_medium

@Composable
fun FriendsAndFamilyScreen(navController: NavController) {

    val items: List<FriendsAndFamilyData> = listOf(
        FriendsAndFamilyData(
            propertyName = "Property 1:",
            id = 1,
            list = listOf<String>(
                "Jane Peterson",
                "Jane@gmail.com",
                "214-234-5222",
                "Wife- Signed up 12/12 2023",
                "Over 21 years old"
            )
        ),
        FriendsAndFamilyData(
            propertyName = "Property 2:",
            id = 2,
            list = listOf<String>(
                "Brock Peterson",
                "Brock@gmail.com"
            )
        ),
        FriendsAndFamilyData(
            propertyName = "Property 3:",
            id = 3,
            list = listOf<String>(
                "Jason Peterson",
                "Jason@gmail.com",
                "214-234-5222",
                "Wife- Signed up 12/12 2023"
            )
        ),
    )

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(top = 26.dp)
                    .padding(horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppIconImage(
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                        .padding(horizontal = 20.dp).heightIn(90.dp)
                )

                Box(
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                ) {
                    LabelText(
                        text = "Friends & Family",
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
                    "The following people have access to your account :",
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth().padding(
                        top = 30.dp
                    ).padding(end = 30.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(Res.font.inter_medium))
                )

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 20.dp)
                ) {
                    items(items) { item ->
                        FriendsAndFamilyItem(navController, item)
                        Spacer(modifier = Modifier.height(20.dp))
                    }

                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Blue
                                ),
                                shape = RoundedCornerShape(12.dp),
                                contentPadding = PaddingValues(
                                    horizontal = 24.dp,
                                    vertical = 12.dp
                                )
                            ) {
                                Text(
                                    text = "Invite a Friend",
                                    color = Color.White,
                                    style = MaterialTheme.typography.titleMedium,
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
    }
}

@Composable
fun FriendsAndFamilyItem(navController: NavController, item: FriendsAndFamilyData) {

    Column(
        modifier = Modifier.fillMaxWidth().border(
            width = 1.dp, color = Color.White, shape = RoundedCornerShape(12.dp)
        ).background(color = LightBlue, shape = RoundedCornerShape(12.dp))
    )
    {
        Row(modifier = Modifier.padding(top = 12.dp).fillMaxWidth().padding(horizontal = 20.dp)) {
            Text(
                item.propertyName,
                color = Color.White,
                modifier = Modifier.weight(1f).padding(end = 20.dp),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(Res.font.inter_medium)),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start
            )

            Icon(
                painterResource(Res.drawable.ic_delete),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.padding(start = 20.dp).size(22.dp)
            )
        }
        Box(
            modifier = Modifier.padding(top = 12.dp).fillMaxWidth().height(1.dp)
                .background(color = Color.White)
        )

        item.list.forEachIndexed { index, s ->
            Text(
                s,
                color = Color.White,
                modifier = Modifier.padding(top = 12.dp).fillMaxWidth().padding(horizontal = 20.dp),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(Res.font.inter_medium)),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start
            )

            if (index != item.list.size - 1) {
                Box(
                    modifier = Modifier.padding(top = 12.dp).fillMaxWidth().height(1.dp)
                        .background(color = White20Per)
                )
            } else {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

data class FriendsAndFamilyData(val propertyName: String, val id: Int, val list: List<String>)