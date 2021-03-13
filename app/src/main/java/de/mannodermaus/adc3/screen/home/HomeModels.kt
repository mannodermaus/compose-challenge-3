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

import de.mannodermaus.adc3.Item
import de.mannodermaus.adc3.R

object HomeModels {
    val favoriteCollections = listOf(
        Item("Short mantras", R.drawable.novacek),
        Item("Stress and anxiety", R.drawable.jim),
        Item("Overwhelmed", R.drawable.ruvim),
        Item("Nature meditations", R.drawable.ahead),
        Item("Self-massage", R.drawable.webb),
        Item("Nightly wind down", R.drawable.novacek),
    )

    val alignBodyItems = listOf(
        Item("Inversions", R.drawable.chevanon),
        Item("Quick yoga", R.drawable.wiguna),
        Item("Stretching", R.drawable.cliff),
        Item("Tabata", R.drawable.fairytale2),
        Item("Pre-natal yoga", R.drawable.freestocksorg),
    )

    val alignMindItems = listOf(
        Item("Meditate", R.drawable.fairytale1),
        Item("With kids", R.drawable.ushakova),
        Item("Aromatherapy", R.drawable.grabowska),
        Item("On the go", R.drawable.nueaon),
        Item("With pets", R.drawable.cottonbro),
        Item("High stress", R.drawable.cowley),
    )
}
