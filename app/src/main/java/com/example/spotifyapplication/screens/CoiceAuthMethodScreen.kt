package com.example.spotifyapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spotifyapplication.R
import com.example.spotifyapplication.Screen
import com.example.spotifyapplication.ui.theme.DividerGrayColor
import com.example.spotifyapplication.ui.theme.GreenSpotify

@Composable
fun CoiceAuthMethodScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(175.dp))
        Row (
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.big_spotify_logo),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(55.dp))
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Enjoy listening to music",
                color = Color.Black,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.padding(start = 30.dp, end = 30.dp),
                text = "Spotify is a proprietary Swedish audio streaming and media services provider ",
                color = DividerGrayColor,
                fontSize = 17.sp
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(GreenSpotify),
                onClick = {
                    navController.navigate(Screen.Register.route)
                }) {
                Text(
                    text = "Register",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(52.dp))
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                onClick = {
                    navController.navigate(Screen.SignIn.route)
                }) {
                Text(
                    text = "Sign In",
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }
        }
    }
}

