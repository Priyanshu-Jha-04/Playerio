package com.example.playerio.screens.landing

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.playerio.R
import com.example.playerio.navigation.PlayerioScreens
import com.google.android.gms.common.util.CollectionUtils.listOf
import kotlinx.coroutines.delay

@Composable
fun LandingScreen01(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp


    Surface(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier.fillMaxSize(),
            color = Color.Transparent) {
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
                .zIndex(3.0F).offset(y = -screenHeight * 0.15f),
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .statusBarsPadding().zIndex(2.0F),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(
                    onClick = { navController.navigate(PlayerioScreens.HomeScreen.name) },
                    modifier = Modifier.align(Alignment.End),
                    shape = RoundedCornerShape(40.dp),
                    elevation = ButtonDefaults.buttonElevation(3.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Text(
                        "Skip",
                        color = Color.White,
                        fontSize = (screenWidth * 0.045f).value.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Default
                    )
                }


                Image(
                    painter = painterResource(R.drawable.headphones),
                    contentDescription = "Headphones",
                    modifier = Modifier
                        .height(screenHeight * 0.60f)
                        .width(screenWidth * 0.65f),
                    alignment = Alignment.Center
                )

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-70).dp)) {
                    Spacer(modifier = Modifier.padding(start = 10.dp))
                    Text(
                        "Playerio",
                        color = Color.White,
                        fontSize = (screenWidth * 0.085f).value.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Default
                    )
                    Text(
                        ".",
                        color = Color(0xFF4527A0),
                        fontSize = (screenWidth * 0.14f).value.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Default,
                        modifier = Modifier.offset(y = -20.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 1.dp)
                        .offset(y = -screenHeight * 0.1f)
                ) {
                    Text(
                        "Playerio offers seamless audio playback and",
                        color = Color.White,
                        fontSize = (screenWidth * 0.035f).value.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Default
                    )
                    Text(
                        "emulates the core functionalities of YouTube Music.",
                        color = Color.White,
                        fontSize = (screenWidth * 0.035f).value.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Default
                    )
                    Spacer(modifier = Modifier.padding(top = 10.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(R.drawable.circle1),
                            contentDescription = "Intro Screen Completion Index",
                            modifier = Modifier
                                .height(10.dp)
                                .width(10.dp),
                            alignment = Alignment.Center
                        )
                        Spacer(modifier = Modifier.padding(start = 10.dp))
                        Image(
                            painter = painterResource(R.drawable.circle2),
                            contentDescription = "Intro Screen Completion Index",
                            modifier = Modifier
                                .height(10.dp)
                                .width(10.dp),
                            alignment = Alignment.Center
                        )
                        Spacer(modifier = Modifier.padding(start = 10.dp))
                        Image(
                            painter = painterResource(R.drawable.circle2),
                            contentDescription = "Intro Screen Completion Index",
                            modifier = Modifier
                                .height(10.dp)
                                .width(10.dp),
                            alignment = Alignment.Center
                        )
                    }
                    Spacer(modifier = Modifier.padding(top = 22.dp))

                    Button(
                        onClick = { navController.navigate(PlayerioScreens.LandingScreen02.name) },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .height(60.dp)
                            .fillMaxWidth(0.75f),
                        shape = RoundedCornerShape(40.dp),
                        elevation = ButtonDefaults.buttonElevation(3.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF4527A0)),
                        contentPadding = ButtonDefaults.ContentPadding
                    ) {
                        Text(
                            "Next",
                            color = Color(0xFFF7F7F7),
                            fontSize = (20.sp).value.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.SansSerif
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingScreen01Preview() {
    val navController = rememberNavController()
    LandingScreen01(navController = navController)
}