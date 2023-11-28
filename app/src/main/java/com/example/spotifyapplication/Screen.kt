package com.example.spotifyapplication

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object CoiceAuth: Screen(route = "coice_auth_method_screen")
    object Register: Screen(route = "register_screen")
    object SignIn: Screen(route = "sign_in_screen")
}