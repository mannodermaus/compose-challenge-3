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
package de.mannodermaus.adc3.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults.elevation
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.mannodermaus.adc3.Item
import de.mannodermaus.adc3.Navigator
import de.mannodermaus.adc3.ui.components.MyTextField
import de.mannodermaus.adc3.ui.components.ScrollableHorizontalGrid
import de.mannodermaus.adc3.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import java.util.Locale

@Composable
fun HomeScreen(navigator: Navigator) {
    var searchInput by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 56.dp)
                    .verticalScroll(scrollState)
            ) {
                MyTextField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    value = searchInput,
                    onValueChange = { searchInput = it },
                    hint = "Search",
                    leftIcon = Icons.Filled.Search,
                )
                FavoriteCollectionGrid(
                    items = HomeModels.favoriteCollections,
                    onItemClicked = {},
                )
                ScrollableCircleContent(
                    title = "Align Your Body",
                    items = HomeModels.alignBodyItems,
                    onItemClicked = {},
                )
                ScrollableCircleContent(
                    title = "Align Your Mind",
                    items = HomeModels.alignMindItems,
                    onItemClicked = {},
                )
            }

            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background,
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                BottomNavigationItem(
                    selected = true,
                    label = { Text(text = "Home".toUpperCase(Locale.ROOT)) },
                    onClick = { /*TODO*/ },
                    icon = {
                        Image(
                            colorFilter = tint(MaterialTheme.colors.onBackground),
                            modifier = Modifier.size(18.dp),
                            imageVector = Icons.Filled.Spa,
                            contentDescription = null
                        )
                    }
                )
                BottomNavigationItem(
                    selected = false,
                    label = { Text(text = "Profile".toUpperCase(Locale.ROOT)) },
                    onClick = { /*TODO*/ },
                    icon = {
                        Image(
                            colorFilter = tint(MaterialTheme.colors.onBackground),
                            alpha = ContentAlpha.medium,
                            modifier = Modifier.size(18.dp),
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = null
                        )
                    }
                )
            }

            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = elevation(0.dp),
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.BottomCenter).offset(y = (-28).dp)
            ) {
                Image(
                    imageVector = Icons.Filled.PlayArrow,
                    colorFilter = tint(LocalContentColor.current),
                    contentDescription = "Play",
                    modifier = Modifier.size(24.dp),
                )
            }
        }
    }
}

@Composable
private fun FavoriteCollectionGrid(
    items: List<Item>,
    onItemClicked: (Item) -> Unit,
    modifier: Modifier = Modifier
) {
    ScrollableHorizontalGrid(
        modifier = modifier,
        title = "Favorite Collections",
        items = items,
        rowCount = 2
    ) { item ->
        Surface(
            modifier = Modifier
                .size(192.dp, 56.dp)
                .clip(MaterialTheme.shapes.small)
                .clickable { onItemClicked(item) }
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier
                        .width(56.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(item.imageRes),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(end = 16.dp),
                    text = item.title,
                    style = MaterialTheme.typography.h3,
                    maxLines = 2
                )
            }
        }
    }
}

@Composable
private fun ScrollableCircleContent(
    title: String,
    items: List<Item>,
    onItemClicked: (Item) -> Unit,
) {
    val itemWidth = 88.dp

    ScrollableHorizontalGrid(title = title, items = items) { item ->
        Column(modifier = Modifier.width(itemWidth)) {
            Image(
                painter = painterResource(item.imageRes),
                contentDescription = "todo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .clickable { onItemClicked(item) }
            )
            Text(
                text = item.title,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .align(Alignment.CenterHorizontally),
                maxLines = 1,
                style = MaterialTheme.typography.h3,
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        HomeScreen(navigator = {})
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScreen(navigator = {})
    }
}
