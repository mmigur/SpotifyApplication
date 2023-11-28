package com.example.spotifyapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation
import com.example.spotifyapplication.screens.CoiseAuthMethodScreen
import com.example.spotifyapplication.screens.RegisterScreen
import com.example.spotifyapplication.ui.theme.SpotifyApplicationTheme

import com.example.spotifyapplication.screens.splash.SplashScreen
import com.example.spotifyapplication.screens.SigIn


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoiseAuthMethodScreen()
        }
    }
}