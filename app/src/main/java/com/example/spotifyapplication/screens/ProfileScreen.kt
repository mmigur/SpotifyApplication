package com.example.spotifyapplication.screens

import android.annotation.SuppressLint
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spotifyapplication.R
import com.example.spotifyapplication.ui.theme.DividerGrayColor
import com.example.spotifyapplication.ui.theme.ExtraLightGray

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.padding(top = 28.dp),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(horizontal = 28.dp),
                navigationIcon = {
                    FilledIconButton(
                        onClick = {
                            navController.navigateUp()
                        },
                        colors = IconButtonDefaults.filledIconButtonColors(containerColor = ExtraLightGray)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.arrow_left),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text(
                        text = "Profile",
                        fontSize = 20.sp
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                modifier = Modifier
                    .scale(3f),
                painter = painterResource(id = R.drawable.profile_example),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Soroushnorozyui@gmail.com")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Soroushnrz",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(14.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(
                    modifier = Modifier.width(100.dp),
                    thickness = 1.dp,
                    color = DividerGrayColor
                )
                Spacer(modifier = Modifier.width(11.dp))
                Text(text = "Public playlists")
                Spacer(modifier = Modifier.width(11.dp))
                Divider(
                    modifier = Modifier.width(100.dp),
                    thickness = 1.dp,
                    color = DividerGrayColor
                )
            }
            Spacer(modifier = Modifier.height(44.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
            ) {
                TrackCardComponent(
                    songName = "Dont smile at me",
                    artistName = "Billie Eilish",
                    trackDuration = "5:33",
                    painterResourceId = R.drawable.track_1
                )
                Spacer(modifier = Modifier.height(30.dp))
                TrackCardComponent(
                    songName = "As It Was",
                    artistName = "Harry Styles",
                    trackDuration = "5:33",
                    painterResourceId = R.drawable.track_2
                )
                Spacer(modifier = Modifier.height(30.dp))
                TrackCardComponent(
                    songName = "Super Freaky Girl",
                    artistName = "Nicki Minaj",
                    trackDuration = "5:33",
                    painterResourceId = R.drawable.track_3
                )
                Spacer(modifier = Modifier.height(30.dp))
                TrackCardComponent(
                    songName = "Bad Habit",
                    artistName = "Steve Lacy",
                    trackDuration = "5:33",
                    painterResourceId = R.drawable.track_4
                )
                Spacer(modifier = Modifier.height(30.dp))
                TrackCardComponent(
                    songName = "Planet Her",
                    artistName = "Doja Cat",
                    trackDuration = "5:33",
                    painterResourceId = R.drawable.track_5
                )
            }
        }
    }
}

@Composable
fun TrackCardComponent(
    songName: String,
    artistName: String,
    trackDuration: String,
    painterResourceId: Int
) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            modifier = Modifier
                .scale(3f),
            painter = painterResource(id = painterResourceId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(40.dp))
        Column {
            Text(text = songName)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = artistName)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = trackDuration)
        Spacer(modifier = Modifier.width(32.dp))
        Image(
            painter = painterResource(id = R.drawable.more_horizontal),
            contentDescription = null
        )
    }
}