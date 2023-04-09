package com.dogpa.kp12bottombar.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dogpa.kp12bottombar.bottoms.*
import com.dogpa.kp12bottombar.model.BottomBarScreenView


@Composable
fun BottomNavGraphView(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreenView.List.route
    ) {
        composable(route = BottomBarScreenView.List.route) {
            PageView("列表",Color.Green)
        }
        composable(route = BottomBarScreenView.Map.route) {
            PageView("地圖",Color.Red)
        }
        composable(route = BottomBarScreenView.Favorite.route) {
            PageView("最愛",Color.Blue)
        }
        composable(route = BottomBarScreenView.Other.route) {
            PageView("其他",Color.Yellow)
        }
    }
}