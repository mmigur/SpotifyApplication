package com.example.spotifyapplication.screens

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spotifyapplication.R
import com.example.spotifyapplication.ui.theme.DividerGrayColor
import com.example.spotifyapplication.ui.theme.ExtraLightGray

data class SongModel(
    val songName: String,
    val artistName: String,
    val trackDuration: String,
    val painterResourceId: Int
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val songList = listOf(
        SongModel(
            songName = "Planet Her",
            artistName = "Doja Cat",
            trackDuration = "5:33",
            painterResourceId = R.drawable.track_5
        ),
        SongModel(
            songName = "Bad Habit",
            artistName = "Steve Lacy",
            trackDuration = "5:33",
            painterResourceId = R.drawable.track_4
        ),
        SongModel(
            songName = "Dont smile at me",
            artistName = "Billie Eilish",
            trackDuration = "5:33",
            painterResourceId = R.drawable.track_1
        ),
        SongModel(
            songName = "Super Freaky Girl",
            artistName = "Nicki Minaj",
            trackDuration = "5:33",
            painterResourceId = R.drawable.track_3
        ),
        SongModel(
            songName = "As It Was",
            artistName = "Harry Styles",
            trackDuration = "5:33",
            painterResourceId = R.drawable.track_2
        ),
        SongModel(
            songName = "As It Was",
            artistName = "Harry Styles",
            trackDuration = "5:33",
            painterResourceId = R.drawable.track_2
        ),
        SongModel(
            songName = "As It Was",
            artistName = "Harry Styles",
            trackDuration = "5:33",
            painterResourceId = R.drawable.track_2
        )
    )

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
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.more_vertical), contentDescription = null)
                    }
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

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.fillMaxHeight(),
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                items(items = songList) { item ->
                    TrackCardComponent(
                        songName = item.songName,
                        artistName = item.artistName,
                        trackDuration = item.trackDuration,
                        painterResourceId = item.painterResourceId,
                    )
                }
            }
        }
    }
}

@Composable
fun TrackCardComponent(
    songName: String,
    artistName: String,
    trackDuration: String,
    painterResourceId: Int,
) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            modifier = Modifier.height(58.dp).width(58.dp),
            painter = painterResource(id = painterResourceId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(40.dp))
        Column {
            Text(
                text = songName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = artistName)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = trackDuration)
        Spacer(modifier = Modifier.width(32.dp))
        IconButton(onClick = {
        }) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.more_horizontal), contentDescription = null)
        }
    }
}