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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fiveexceptions.seismocon.core.commonComposables.AppIconImage
import com.fiveexceptions.seismocon.core.commonComposables.CommonButton
import com.fiveexceptions.seismocon.core.commonComposables.LabelText
import com.fiveexceptions.seismocon.core.commonComposables.TextFieldWithLeadingIcon
import com.fiveexceptions.seismocon.ui.DarkBlue
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import seismocon.composeapp.generated.resources.Res
import seismocon.composeapp.generated.resources.ic_password
import seismocon.composeapp.generated.resources.ic_user
import seismocon.composeapp.generated.resources.img_auth_bg

@Composable
@Preview
fun LoginScreen(
    signInClick: () -> Unit = {},
    guestClick: () -> Unit = {},
    forgotPasswordClick: () -> Unit = {}
) {
    var userName by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
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
                        text = "Log in",
                        modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                    )

                    TextFieldWithLeadingIcon(
                        value = userName,
                        onValueChange = { userName = it },
                        leadingIcon = painterResource(Res.drawable.ic_user),
                        placeholder = "User Name",
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    )

                    TextFieldWithLeadingIcon(
                        value = password,
                        onValueChange = { password = it },
                        leadingIcon = painterResource(Res.drawable.ic_password),
                        placeholder = "Password",
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    )

                    CommonButton(
                        text = "Sign in",
                        onClick = { signInClick() },
                        modifier = Modifier.padding(top = 36.dp)
                    )

                    CommonButton(
                        text = "Guest",
                        onClick = { guestClick() },
                        modifier = Modifier.padding(top = 20.dp)
                    )

                    TextButton(
                        onClick = { forgotPasswordClick() },
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