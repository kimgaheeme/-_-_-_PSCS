package com.example.fcm.Screen

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {

    //startDestination을 Screen1으로 하면 오류남 startDestination으로 설정한것은 무조건 직접적으로 바로 연결 되어있어야 한다.
    // navigation destination 1826348280 is not a direct child of this NavGraph
    NavHost(navController = navController, startDestination = BottomScreen.Home.route) {
        screen1Graph(navController)
        composable(BottomScreen.Home.route) {
            Home(navController = navController)
        }
        composable(BottomScreen.SubHome.route) {
            SubHome(navController = navController)
        }
    }
}

fun NavGraphBuilder.screen1Graph(navController: NavController) {
    navigation(startDestination = Screen.SCREEN1, route = GRAPH.GRAPH1) {
        composable(Screen.SCREEN1) { Screen1(navController) }
        composable(Screen.SCREEN3) { Screen3(navController) }
        //graph는 안에 있어야 하나 밖에 있어야 하나... 둘 다 작동 되긴 함
        screen2Graph(navController)
    }
    composable(
        route = "${Screen.SCREEN_WITH_ID}/{${Id.ID}}"
    ) { backStackEntry ->
        ScreenId(navController = navController, id = backStackEntry.arguments!!.getString("id")!!)
    }
}


fun NavGraphBuilder.screen2Graph(navController: NavController) {
    navigation(startDestination = Screen.SCREEN2, route=GRAPH.GRAPH2) {
        composable(Screen.SCREEN2) { Screen2(navController) }
        composable(Screen.SCREEN4) { Screen4(navController) }
        composable(Screen.SCREEN5) { Screen5(navController) }
    }
}