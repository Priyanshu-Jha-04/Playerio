package com.example.playerio.screens.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.playerio.R

@Composable
fun LandingScreen02(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF41C3D6)
    ) {
        Image(painter = painterResource(R.drawable.girlnobg), contentDescription = "Girl",
            modifier = Modifier.size(width = screenWidth, height = screenHeight * 0.55f).zIndex(1.0F).padding(top = screenHeight * 0.15f), alignment = Alignment.TopStart)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.45f)
                .zIndex(2.0F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight * 0.45f)
                    .padding(top = (screenHeight - (screenHeight * 0.45f) - screenWidth - screenWidth * 0.2f)),
                colors = CardDefaults.cardColors(Color.Transparent),
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF1E1B2E), Color(0xFF13111E))
                            )
                        )
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingScreen02Preview() {
    val navController = rememberNavController()
    LandingScreen02(navController = navController)
}