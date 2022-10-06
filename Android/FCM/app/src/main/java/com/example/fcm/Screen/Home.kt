package com.example.fcm.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    LazyColumn() {
        item {
            Button(onClick = {navController.navigate(Screen.SCREEN1)}) {
                Text("Screen1")
            }
            Text("Home")
        }
        item {
            repeat(50) {
                Text("Home${it}")
            }
        }
    }
}