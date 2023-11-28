package com.example.spotifyapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spotifyapplication.screens.CoiceAuthMethodScreen
import com.example.spotifyapplication.screens.RegisterScreen
import com.example.spotifyapplication.screens.SignInScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CoiceAuth.route
    ){
        composable(
            route = Screen.CoiceAuth.route
        ){
            CoiceAuthMethodScreen(navController = navController)
        }
        composable(
            route = Screen.Register.route
        ){
            RegisterScreen(navController = navController)
        }
        composable(
            route = Screen.SignIn.route
        ){
            SignInScreen(navController = navController)
        }
    }
}