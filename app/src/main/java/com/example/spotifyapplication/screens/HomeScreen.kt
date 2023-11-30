package com.example.spotifyapplication.screens

import android.provider.MediaStore.Audio.Artists
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spotifyapplication.R
import com.example.spotifyapplication.Screen
import com.example.spotifyapplication.ui.theme.DividerGrayColor
import com.example.spotifyapplication.ui.theme.GreenSpotify
import kotlin.math.round

data class AlbumModel(
    val image: Int,
    val name: String,
    val artist: String,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    val albumList = listOf(
        AlbumModel(image = R.drawable.album_1, name = "Bad Guy", artist = "Billie Eilish"),
        AlbumModel(image = R.drawable.album_2, name = "Scorpion", artist = "Drake"),
        AlbumModel(image = R.drawable.album_1, name = "Lilbubblegum", artist = "Billie Eilish"),
        AlbumModel(image = R.drawable.album_1, name = "Lilbubblegum", artist = "Billie Eilish"),
    )
    val selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    Scaffold(
        modifier = Modifier.padding(start = 28.dp, end = 28.dp, top = 28.dp),
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.search_icon), contentDescription = null)
                    }
                },
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.spotify_logo_mini),
                        contentDescription = null
                    )
                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.Profile.route)
                    }) {
                        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.profile_nav_bar_icon), contentDescription = null)
                    }
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
                Row{
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

            Spacer(modifier = Modifier.height(30.dp))
            
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
                Text(text = "Albums", fontSize = 20.sp)
                Spacer(modifier = Modifier.width(11.dp))
                Divider(
                    modifier = Modifier.width(100.dp),
                    thickness = 1.dp,
                    color = DividerGrayColor
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            LazyRow (
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                items(items = albumList) { item ->
                    AlbumCard(
                        imageId = item.image,
                        albumName = item.name,
                        artistName = item.artist
                    )
                }
            }
        }
    }
}

@Composable
fun AlbumCard(
    imageId: Int,
    albumName: String,
    artistName: String
) {
    Column {
        Image(
            modifier = Modifier
                .height(185.dp)
                .width(147.dp),
            painter = painterResource(id = imageId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            modifier = Modifier.padding(start = 7.dp),
            text = albumName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            modifier = Modifier.padding(start = 7.dp),
            text = artistName,
            fontSize = 17.sp
        )
    }
}