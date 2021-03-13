# MySoothe

<!--- Replace <OWNER> with your Github Username and <REPOSITORY> with the name of your repository. -->
<!--- You can find both of these in the url bar when you open your repository in github. -->
![Workflow result](https://github.com/mannodermaus/compose-challenge-3/workflows/Check/badge.svg)


## :scroll: Description
<!--- Describe your app in one or two sentences -->
Find your inner peace with MySoothe, an implementation of the design by Google for the Android Developer Challenge for Jetpack Compose.

## :bulb: Motivation and Context
<!--- Optionally point readers to interesting parts of your submission. -->
<!--- What are you especially proud of? -->
This was a fun exercise! I made use of reusable custom components, utilizing the concept of Slot APIs
to create templates for different kinds of content. From the usability perspective, I'm proud of the
flexibility of my scrollable grid. It only needs to take care of one or two rows, but the implementation
should accommodate even more rows without any trouble. Thanks to the strict design document, building
this app with dark mode in mind was an absolute breeze.

I lost a lot of time (and likely, the competition) to TextField's inability to correctly align the leading icon with its text.
Ultimately I gave up as I believe this to be a bug in the component itself, but I didn't want to reimplement the entirety of an input field for this challenge.
Therefore, this wouldn't been eligible for the win anyway as the alignment of the input fields doesn't match the design,
but I suppose that's just what it is. :man-shrugging:

## :camera_flash: Screenshots
<!-- You can add more screenshots here if you like -->
<img src="/results/screenshot_1.png" width="260">&emsp;<img src="/results/screenshot_2.png" width="260">&emsp;<img src="/results/screenshot_3.png" width="260">
<img src="/results/screenshot_1d.png" width="260">&emsp;<img src="/results/screenshot_2d.png" width="260">&emsp;<img src="/results/screenshot_3d.png" width="260">

## License
```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```