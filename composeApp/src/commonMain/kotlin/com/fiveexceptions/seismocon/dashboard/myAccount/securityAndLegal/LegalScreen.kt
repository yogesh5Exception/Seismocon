package com.fiveexceptions.seismocon.dashboard.myAccount.securityAndLegal

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.core.commonComposables.popSafeBack
import com.fiveexceptions.seismocon.dashboard.home.gradientBackground
import com.fiveexceptions.seismocon.ui.GradientDarkBlue
import com.fiveexceptions.seismocon.ui.GradientLightBlue
import com.fiveexceptions.seismocon.ui.White10Per
import com.fiveexceptions.seismocon.ui.White30Per
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_back_white_color
import seismocon.composeapp.generated.resources.inter_medium
import seismocon.composeapp.generated.resources.inter_regular

@Composable
fun LegalScreen(navController: NavController) {

    var allCheck by rememberSaveable { mutableStateOf(true) }
    var textCheck by rememberSaveable { mutableStateOf(true) }
    var emailCheck by rememberSaveable { mutableStateOf(true) }
    var newsLetterCheck by rememberSaveable { mutableStateOf(true) }
    var researchCheck by rememberSaveable { mutableStateOf(true) }
    var marketingCheck by rememberSaveable { mutableStateOf(true) }
    var userLicenseAgreementCheck by rememberSaveable { mutableStateOf(true) }
    var termsAndConditionsCheck by rememberSaveable { mutableStateOf(true) }
    var privacyPolicyCheck by rememberSaveable { mutableStateOf(true) }
    var seismoconDesclaimerCheck by rememberSaveable { mutableStateOf(true) }

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize()
                .gradientBackground(listOf(GradientDarkBlue, GradientLightBlue), angle = -56f)
        ) {

            Scaffold(
                containerColor = Color.Transparent, modifier = Modifier.fillMaxSize()
            ) { paddingValues ->

                Column(
                    modifier = Modifier.fillMaxSize().padding(paddingValues).padding(top = 20.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
                    ) {
                        LabelText(
                            text = "Legal",
                            modifier = Modifier.fillMaxWidth().align(Alignment.Center),
                            textStyle = MaterialTheme.typography.titleMedium
                        )

                        Box(
                            modifier = Modifier.size(36.dp).background(
                                color = White10Per, shape = RoundedCornerShape(8.dp)
                            ).padding(7.dp).clickable(
                                onClick = {
                                    navController.popSafeBack()
                                }).align(Alignment.CenterStart)
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
                        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
                    ) {

                        Text(
                            text = "I agree to receive & share",
                            modifier = Modifier.padding(top = 30.dp).fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(Font(Res.font.inter_medium)),
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Start
                        )

                        SecurityAndLegalItems(
                            "All",
                            Modifier.padding(top = 30.dp).fillMaxWidth(),
                            check = allCheck,
                            { allCheck = it })

                        SecurityAndLegalItems(
                            "Text",
                            Modifier.padding(top = 10.dp).fillMaxWidth(),
                            check = textCheck,
                            { textCheck = it })


                        SecurityAndLegalItems(
                            "Email",
                            Modifier.padding(top = 10.dp).fillMaxWidth(),
                            check = emailCheck,
                            { emailCheck = it })

                        SecurityAndLegalItems(
                            "Newsletter",
                            Modifier.padding(top = 10.dp).fillMaxWidth(),
                            check = newsLetterCheck,
                            { newsLetterCheck = it })

                        SecurityAndLegalItems(
                            "Research",
                            Modifier.padding(top = 10.dp).fillMaxWidth(),
                            check = researchCheck,
                            { researchCheck = it })

                        SecurityAndLegalItems(
                            "Marketing",
                            Modifier.padding(top = 10.dp).fillMaxWidth(),
                            check = marketingCheck,
                            { marketingCheck = it })

                        SecurityAndLegalItems(
                            "User License Agreement",
                            Modifier.padding(top = 10.dp).fillMaxWidth(),
                            check = userLicenseAgreementCheck,
                            { userLicenseAgreementCheck = it })

                        SecurityAndLegalItems(
                            "Terms and Conditions",
                            Modifier.padding(top = 10.dp).fillMaxWidth(),
                            check = termsAndConditionsCheck,
                            { termsAndConditionsCheck = it })

                        SecurityAndLegalItems(
                            "Privacy Policy",
                            Modifier.padding(top = 10.dp).fillMaxWidth(),
                            check = privacyPolicyCheck,
                            { privacyPolicyCheck = it })

                        SecurityAndLegalItems(
                            "Seismocon Disclaimer",
                            Modifier.padding(top = 10.dp).fillMaxWidth(),
                            check = seismoconDesclaimerCheck,
                            { seismoconDesclaimerCheck = it })

                        Spacer(
                            modifier = Modifier.height(50.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SecurityAndLegalItems(
    text: String,
    modifier: Modifier = Modifier,
    check: Boolean,
    onCheckChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier.padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .clip(RoundedCornerShape(3.dp))
                .border(width = 1.dp, color = White30Per, shape = RoundedCornerShape(3.dp)),
            contentAlignment = Alignment.Center
        ) {
            Checkbox(
                checked = check,
                onCheckedChange = { onCheckChange.invoke(it) },
                modifier = Modifier.size(20.dp).clip(RoundedCornerShape(3.dp))
                    .padding(4.dp),
                colors = CheckboxDefaults.colors(
                    checkmarkColor = Color.White,
                    checkedColor = Color.Transparent,
                    uncheckedColor = Color.Transparent
                )
            )
        }

        Text(
            text,
            color = Color.White,
            modifier = Modifier.padding(10.dp).fillMaxWidth().weight(1f),
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = FontFamily(Font(Res.font.inter_regular))
        )
    }
}