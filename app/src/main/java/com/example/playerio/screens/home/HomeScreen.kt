package com.example.playerio.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.playerio.R

@Composable
fun HomeScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp


    Surface(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Transparent
        ) {
        }
        Image(
            painter = painterResource(R.drawable.ellipse2),
            contentDescription = "ellipse",
            modifier = Modifier
                .height(screenHeight * 0.60f)
                .width(screenWidth * 0.65f)
                .zIndex(3.0F),
            alignment = Alignment.BottomStart
        )
        Image(
            painter = painterResource(R.drawable.ellipse1),
            contentDescription = "ellipse",
            modifier = Modifier
                .height(screenHeight * 0.65f)
                .width(screenWidth * 0.65f)
                .zIndex(3.0F)
                .offset(y = -screenHeight * 0.15f),
            alignment = Alignment.Center
        )
        Image(
            painter = painterResource(R.drawable.ellipse3),
            contentDescription = "ellipse",
            modifier = Modifier
                .height(screenHeight * 0.65f)
                .width(screenWidth * 0.65f)
                .zIndex(3.0F),
            alignment = Alignment.TopEnd
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF1E1B2E), Color(0xFF13111E))
                    )
                )
                .padding(10.dp)

        ) {

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}