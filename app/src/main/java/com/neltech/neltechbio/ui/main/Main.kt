package com.neltech.neltechbio.ui.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.neltech.neltechbio.ui.posters.Posters

@Composable
fun DisneyMainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavScreen.Home.route) {
        composable(NavScreen.Home.route) {
            Posters(
                viewModel = hiltViewModel()
            ) {

                navController.navigate("${NavScreen.Poster.route}/$id")

            }
        }
        composable(NavScreen.Poster.route) {

        }
    }
}

sealed class NavScreen(val route: String) {
    object Home : NavScreen("Home")
    object Poster : NavScreen("Poster") {
        const val routeWithArgument: String = "Poster/{posterId}"
        const val argument0: String = "posterId"
    }
}