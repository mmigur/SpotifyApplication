package com.example.spotifyapplication

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object CoiceAuth: Screen(route = "coice_auth_method_screen")
    object Register: Screen(route = "register_screen")
    object SignIn: Screen(route = "sign_in_screen")
    object Profile: Screen(route = "profile_screen")
    object FavoriteCollectionScreen: Screen(route = "favorite_collection_screen_route")
}