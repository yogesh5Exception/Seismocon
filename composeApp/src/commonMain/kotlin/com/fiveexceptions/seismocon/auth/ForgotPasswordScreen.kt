package com.fiveexceptions.seismocon.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.core.commonComposables.CommonButton
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.core.commonComposables.TextFieldWithLeadingIcon
import com.fiveexceptions.seismocon.ui.DarkBlue
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_email
import seismocon.composeapp.generated.resources.img_auth_bg
import seismocon.composeapp.generated.resources.inter_medium

@Composable
@Preview
fun ForgotPasswordScreen() {

    var email by rememberSaveable {
        mutableStateOf("")
    }

    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize().background(color = DarkBlue)) {
            Image(
                painter = painterResource(Res.drawable.img_auth_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Scaffold(containerColor = Color.Transparent) { paddingValues ->
                Column(
                    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
                        .padding(paddingValues),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AppIconImage(
                        modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                            .padding(horizontal = 36.dp).heightIn(110.dp)
                    )

                    LabelText(
                        text = "Forgot Password",
                        modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                    )

                    Text(
                        text = "Enter your email to reset your password.",
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 60.dp),
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(Res.font.inter_medium)),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )


                    TextFieldWithLeadingIcon(
                        value = email,
                        onValueChange = { email = it },
                        leadingIcon = painterResource(Res.drawable.ic_email),
                        placeholder = "Email Address",
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        iconBgPadding = 7.dp
                    )

                    CommonButton(
                        text = "Reset Password",
                        onClick = { },
                        modifier = Modifier.padding(top = 36.dp)
                    )

                    TextButton(
                        onClick = { },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text(
                            text = "Forgot Password?",
                            color = Color.White,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}