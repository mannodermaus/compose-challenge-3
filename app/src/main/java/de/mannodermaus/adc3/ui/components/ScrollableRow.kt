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

import androidx.annotation.IntRange
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.mannodermaus.adc3.ui.theme.MyTheme
import java.util.Locale
import kotlin.math.min

@Composable
fun <T> ScrollableHorizontalGrid(
    title: String,
    items: List<T>,
    modifier: Modifier = Modifier,
    @IntRange(from = 1) rowCount: Int = 1,
    itemContent: @Composable (T) -> Unit,
) {
    val horizontalPadding = 16.dp
    val contentPadding = 8.dp
    val scrollState = rememberScrollState()

    Column(modifier) {
        Text(
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp)
                .padding(horizontal = horizontalPadding),
            text = title.toUpperCase(Locale.ROOT),
            style = MaterialTheme.typography.h2,
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Scrollable content, divided into columns
        // (if more than 1 column is requested, split up the list accordingly)
        val itemsPerColumn = if (rowCount == 1) {
            items.size
        } else {
            items.size / rowCount
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
        ) {
            for (rowIndex in 0 until rowCount) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = contentPadding)
                ) {
                    val startIndex = rowIndex * itemsPerColumn
                    val endIndex = min(items.size, startIndex + itemsPerColumn) - 1

                    for (itemIndex in startIndex..endIndex) {
                        val item = items[itemIndex]

                        // Before the first and after the last item in each row, add the "horizontalPadding".
                        // For all items in-between, use the contentPadding
                        Spacer(
                            modifier = Modifier.width(
                                if (itemIndex == startIndex) {
                                    horizontalPadding
                                } else {
                                    contentPadding
                                }
                            )
                        )

                        itemContent(item)

                        if (itemIndex == endIndex) {
                            Spacer(modifier = Modifier.width(horizontalPadding))
                        }
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        ScrollableHorizontalGrid(title = "Title", items = listOf("Item 1", "Item 2")) {
            Text(modifier = Modifier.size(36.dp).background(Color.Gray), text = it)
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        ScrollableHorizontalGrid(title = "Title", items = listOf("Item 1", "Item 2")) {
            Text(modifier = Modifier.size(36.dp).background(Color.Gray), text = it)
        }
    }
}
