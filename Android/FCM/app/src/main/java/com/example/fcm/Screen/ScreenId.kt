package com.example.fcm.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ScreenId(navController: NavController, id: String) {
    Column() {
        Text(Screen.SCREEN_WITH_ID)
        Text(id)
    }
}

