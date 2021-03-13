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
package de.mannodermaus.adc3.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.Locale

enum class MyButtonStyle {
    Primary,
    Secondary
}

@Composable
fun MyButton(
    style: MyButtonStyle,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = when (style) {
        MyButtonStyle.Primary -> ButtonDefaults.buttonColors()
        MyButtonStyle.Secondary -> ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary
        )
    }

    Button(
        colors = colors,
        shape = MaterialTheme.shapes.medium,
        onClick = onClick,
        elevation = null,
        modifier = modifier.fillMaxWidth().height(72.dp)
    ) {
        Text(text = text.toUpperCase(Locale.ROOT))
    }
}
