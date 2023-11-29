package com.example.spotifyapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyapplication.R
import com.example.spotifyapplication.Screen
import com.example.spotifyapplication.ui.theme.GreenSpotify

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.padding(start = 28.dp, end = 28.dp, top = 28.dp),
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = null
                    )
                },
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.spotify_logo_mini),
                        contentDescription = null
                    )
                },
                actions = {
                    Image(
                        painter = painterResource(id = R.drawable.more_vertical),
                        contentDescription = null
                    )
                }
            )
        }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier
                    .width(325.dp)
                    .height(130.dp),
                colors = CardDefaults.cardColors(GreenSpotify),
                shape = RoundedCornerShape(30.dp)
            ) {
                Row (

                ){
                    Column (
                        modifier = Modifier.padding(
                            start = 20.dp,
                            top = 15.dp,
                            bottom = 10.dp
                        ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ){
                        Text(
                            text = "New Album",
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "Happier Than",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "Ever",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "Billie Eilish",
                            color = Color.White
                        )
                    }
                    Image(
                        modifier = Modifier
                            .height(184.dp)
                            .scale(2f)
                            .padding(end = 24.dp),
                        painter = painterResource(id = R.drawable.beillie_eilish_top),
                        contentDescription = null
                    )
                }
            }
        }
    }
}