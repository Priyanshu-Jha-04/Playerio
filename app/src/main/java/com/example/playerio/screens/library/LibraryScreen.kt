package com.example.playerio.screens.library

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.playerio.screens.home.HomeScreen

@Composable
fun LibraryScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(),
    ) {

    }
}

@Preview
@Composable
fun LibraryScreenPreview() {
    val navController = rememberNavController()
    LibraryScreen(navController = navController)
}