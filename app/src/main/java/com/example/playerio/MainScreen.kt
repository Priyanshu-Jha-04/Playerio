package com.example.playerio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Text
import com.example.playerio.data.NavItem
import com.example.playerio.navigation.PlayerioScreens
import com.example.playerio.screens.home.HomeScreen
import com.example.playerio.screens.library.LibraryScreen
import com.example.playerio.screens.playing.PlayingScreen
import com.example.playerio.screens.settings.SearchScreen


@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val navItemList = listOf(
        NavItem(label = "Home", icon = Icons.Filled.Home),
        NavItem(label = "Search", icon = Icons.Filled.Search),
        NavItem(label = "Now Playing", icon = Icons.Filled.MusicNote),
        NavItem(label = "Library", icon = Icons.Filled.LibraryMusic)
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier,
                containerColor = Color(0xFF1E1B2E)
            ) {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "Icon")
                        },
                        label = {
                            Text(navItem.label)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(Modifier.padding(innerPadding), selectedIndex)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
    val navController = rememberNavController()
    when (selectedIndex) {
        0 -> HomeScreen(navController)
        1 -> SearchScreen(navController)
        2 -> PlayingScreen(navController)
        3 -> LibraryScreen(navController)
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}