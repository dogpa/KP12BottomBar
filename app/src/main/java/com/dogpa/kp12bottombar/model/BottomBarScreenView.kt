package com.dogpa.kp12bottombar.model

import androidx.compose.ui.graphics.Color
import com.dogpa.kp12bottombar.R

sealed class BottomBarScreenView(
    val route: String,
    val title: String,
    val color: Color,
    val iconInt: Int
) {
    object List : BottomBarScreenView(
        route = "list",
        title = "列表",
        color = Color.Green,
        iconInt = R.drawable.baseline_format_list_bulleted_24
    )
    object Map : BottomBarScreenView(
        route = "map",
        title = "地圖",
        color = Color.Red,
        iconInt = R.drawable.outline_location_on_24
    )
    object Favorite : BottomBarScreenView(
        route = "favorite",
        title = "最愛",
        color = Color.Blue,
        iconInt = R.drawable.baseline_favorite_24
    )
    object Other : BottomBarScreenView(
        route = "other",
        title = "其他",
        color = Color.Yellow,
        iconInt = R.drawable.baseline_light_mode_24
    )
}
