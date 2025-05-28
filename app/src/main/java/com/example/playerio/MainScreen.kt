package com.example.playerio

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.Text
import com.example.playerio.screens.home.HomeScreen


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {

            }
        }
    ) { innerPadding ->
        Content(Modifier.padding(innerPadding))
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {

}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}