/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.mannodermaus.adc3.screen.login

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.mannodermaus.adc3.Navigator
import de.mannodermaus.adc3.R
import de.mannodermaus.adc3.Screen
import de.mannodermaus.adc3.ui.components.FormBase
import de.mannodermaus.adc3.ui.components.MyButton
import de.mannodermaus.adc3.ui.components.MyButtonStyle
import de.mannodermaus.adc3.ui.components.MyTextField
import de.mannodermaus.adc3.ui.theme.MyTheme
import de.mannodermaus.adc3.ui.util.themeAwarePainterResource
import java.util.Locale

@Composable
fun LoginScreen(navigator: Navigator) {
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    FormBase(
        modifier = Modifier.fillMaxSize(),
        background = themeAwarePainterResource(
            lightResource = R.drawable.light_login,
            darkResource = R.drawable.dark_login,
        ),
        title = {
            Text(
                text = "Log In".toUpperCase(Locale.ROOT),
                style = MaterialTheme.typography.h1,
            )
        },
        content = {
            MyTextField(
                value = emailInput,
                hint = "Email address",
                onValueChange = { emailInput = it }
            )
            Spacer(modifier = Modifier.height(8.dp))
            MyTextField(
                value = passwordInput,
                hint = "Password",
                onValueChange = { passwordInput = it },
                visualTransformation = PasswordVisualTransformation(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            MyButton(
                style = MyButtonStyle.Primary, text = "Log In",
                onClick = {
                    navigator.navigate(Screen.Home)
                }
            )
            ClickableText(
                modifier = Modifier.paddingFromBaseline(top = 32.dp),
                text = buildAnnotatedString {
                    pushStyle(SpanStyle(color = MaterialTheme.colors.onBackground))
                    append("Don't have an account? ")
                    pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                    append("Sign up")
                },
                style = MaterialTheme.typography.body1,
                onClick = {}
            )
        }
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        LoginScreen(navigator = {})
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        LoginScreen(navigator = {})
    }
}
