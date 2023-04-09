package com.dogpa.kp12bottombar.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dogpa.kp12bottombar.model.BottomBarScreenView

@Composable
fun MainView() {
    val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomBar(navController = navController) }
        ) {
            BottomNavGraphView(navController = navController)
        }
}



@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreenView.List,
        BottomBarScreenView.Map,
        BottomBarScreenView.Favorite,
        BottomBarScreenView.Other,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreenView,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    BottomNavigationItem(
        modifier = Modifier.background(Color.White),
        label = {
            Text(text = screen.title, color = if (selected)   screen.color else Color.Gray)
        },
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = screen.iconInt),
                contentDescription = "Navigation Icon",
                tint = if (selected) screen.color else Color.Gray
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

