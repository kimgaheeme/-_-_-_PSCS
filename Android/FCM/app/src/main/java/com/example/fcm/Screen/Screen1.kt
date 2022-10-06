package com.example.fcm.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Screen1(navController: NavController) {
    Column() {
        var id = "1234"
        Button(onClick = {navController.navigate(Screen.SCREEN2)}) {
            Text("Screen2")
        }
        Button(onClick = {navController.navigate(Screen.SCREEN3)}) {
            Text("Screen3")
        }
        Button(onClick = {navController.navigate("${Screen.SCREEN_WITH_ID}/$id")}) {
            Text("1234")
        }
        Text(Screen.SCREEN1)
    }
}

