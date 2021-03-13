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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.mannodermaus.adc3.ui.theme.MyTheme

@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leftIcon: ImageVector? = null,
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            textColor = MaterialTheme.colors.onSurface,
            placeholderColor = MaterialTheme.colors.onSurface,
        ),
        leadingIcon = leftIcon?.let {
            {
                Image(
                    imageVector = it,
                    colorFilter = tint(MaterialTheme.colors.onSurface),
                    contentDescription = "$hint icon",
                    modifier = Modifier.size(18.dp)
                )
            }
        },
        visualTransformation = visualTransformation,
        textStyle = MaterialTheme.typography.body1,
        value = value,
        placeholder = { Text(text = hint, style = MaterialTheme.typography.body1) },
        onValueChange = onValueChange
    )
}

@Preview
@Composable
fun LightPreviewEmptyText() {
    MyTheme {
        MyTextField(
            value = "",
            onValueChange = {},
            hint = "Hint"
        )
    }
}

@Preview
@Composable
fun LightPreviewIcon() {
    MyTheme {
        MyTextField(
            value = "Search Text",
            onValueChange = {},
            hint = "Search",
            leftIcon = Icons.Filled.Search,
        )
    }
}

@Preview
@Composable
fun LightPreviewWithText() {
    MyTheme {
        MyTextField(
            value = "Hello World",
            onValueChange = {},
            hint = "Hint"
        )
    }
}

@Preview
@Composable
fun DarkPreviewEmptyText() {
    MyTheme(darkTheme = true) {
        MyTextField(
            value = "",
            onValueChange = {},
            hint = "Hint"
        )
    }
}

@Preview
@Composable
fun DarkPreviewIcon() {
    MyTheme(darkTheme = true) {
        MyTextField(
            value = "Search Text",
            onValueChange = {},
            hint = "Search",
            leftIcon = Icons.Filled.Search,
        )
    }
}

@Preview
@Composable
fun DarkPreviewWithText() {
    MyTheme(darkTheme = true) {
        MyTextField(
            value = "Hello World",
            onValueChange = {},
            hint = "Hint"
        )
    }
}
