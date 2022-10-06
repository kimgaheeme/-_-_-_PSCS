package com.example.fcm.Screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

object Screen {
    const val SCREEN1 = "Screen1"
    const val SCREEN2 = "Screen2"
    const val SCREEN3 = "Screen3"
    const val SCREEN4 = "Screen4"
    const val SCREEN5 = "Screen5"
    const val SCREEN_WITH_ID = "ScreenWithId"
}

sealed class BottomScreen(val route: String,val icon: ImageVector, val name: String) {
    object Home : BottomScreen("Home", Icons.Default.Home, "홈")
    object SubHome : BottomScreen("SubHome", Icons.Default.Search, "서브홈")
}

val bottomTabList: List<BottomScreen> = listOf(BottomScreen.Home, BottomScreen.SubHome)

object GRAPH {
    const val GRAPH1 = "Graph1"
    const val GRAPH2 = "Graph2"
}

object Id {
    const val ID = "id"
}