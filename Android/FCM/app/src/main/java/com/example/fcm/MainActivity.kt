package com.example.fcm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fcm.Screen.NavGraph
import com.example.fcm.Screen.Screen1
import com.example.fcm.Screen.bottomTabList
import com.example.fcm.ui.theme.FCMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FCMTheme {
                var NavHostController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigation {
                            val navBackStackEntry by NavHostController.currentBackStackEntryAsState()
                            val current = navBackStackEntry?.destination

                            bottomTabList.forEach {
                                BottomNavigationItem(
                                    icon = { Icon(it.icon, contentDescription = "Home")},
                                    label = { Text(it.name) },
                                    selected = current == it,
                                    onClick = {
                                        NavHostController.navigate(it.route) {
                                            popUpTo(NavHostController.graph.findStartDestination().id) {
                                                saveState
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }

                        }
                    }
                ) {
                    NavGraph(NavHostController)
                }
            }
        }
    }
}
