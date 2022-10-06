package com.example.fcm.Screen

import android.view.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
fun Screen2(navController: NavController) {
    Column() {
        Button(onClick = {navController.navigate("Screen4")}) {
            Text("Screen4")
        }
        Button(onClick = {navController.navigate("Screen5")}) {
            Text("Screen5")
        }
        Text(Screen.SCREEN2)
    }
}
