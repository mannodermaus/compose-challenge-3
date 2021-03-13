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
package de.mannodermaus.adc3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import de.mannodermaus.adc3.screen.home.HomeScreen
import de.mannodermaus.adc3.screen.login.LoginScreen
import de.mannodermaus.adc3.screen.welcome.WelcomeScreen

fun interface Navigator {
    fun navigate(screen: Screen)
}

enum class Screen(
    val destination: String,
    val screenContent: @Composable (Navigator) -> Unit,
) {
    Welcome(
        "welcome",
        screenContent = {
            WelcomeScreen(it)
        }
    ),
    Login(
        "login",
        screenContent = {
            LoginScreen(it)
        }
    ),
    Home(
        "home",
        screenContent = {
            HomeScreen(it)
        }
    ),
}

@Composable
fun MyNavHost(controller: NavHostController) {
    // Wrap in custom class to allow strongly-typed navigation
    val navigator = Navigator { controller.navigate(it.destination) }

    NavHost(navController = controller, startDestination = Screen.Welcome.destination) {
        // Register each screen with the nav host
        Screen.values().forEach { screen ->
            composable(screen.destination) {
                screen.screenContent(navigator)
            }
        }
    }
}
