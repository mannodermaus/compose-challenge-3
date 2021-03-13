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
package de.mannodermaus.adc3.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.mannodermaus.adc3.Navigator
import de.mannodermaus.adc3.R
import de.mannodermaus.adc3.Screen
import de.mannodermaus.adc3.ui.components.FormBase
import de.mannodermaus.adc3.ui.components.MyButton
import de.mannodermaus.adc3.ui.components.MyButtonStyle
import de.mannodermaus.adc3.ui.theme.MyTheme
import de.mannodermaus.adc3.ui.util.themeAwarePainterResource

@Composable
fun WelcomeScreen(navigator: Navigator) {
    FormBase(
        modifier = Modifier.fillMaxSize(),
        background = themeAwarePainterResource(
            lightResource = R.drawable.light_welcome,
            darkResource = R.drawable.dark_welcome,
        ),
        title = {
            Logo()
        },
        content = {
            MyButton(MyButtonStyle.Primary, text = "Sign Up", onClick = { /*TODO*/ })
            Spacer(modifier = Modifier.height(8.dp))
            MyButton(
                MyButtonStyle.Secondary, text = "Log In",
                onClick = {
                    navigator.navigate(Screen.Login)
                }
            )
        }
    )
}

@Composable
private fun Logo(modifier: Modifier = Modifier) {
    Image(
        painter = themeAwarePainterResource(
            lightResource = R.drawable.light_logo,
            darkResource = R.drawable.dark_logo,
        ),
        modifier = modifier,
        contentDescription = "MySoothe logo"
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WelcomeScreen(navigator = {})
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomeScreen(navigator = {})
    }
}
