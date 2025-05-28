package com.example.playerio.screens.landing

import android.widget.Space
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.playerio.R
import com.example.playerio.navigation.PlayerioScreens
import com.example.playerio.ui.theme.PlayerioTheme
import kotlin.math.exp

@Composable
fun LandingScreen02(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF41C3D6)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.45f)
                .zIndex(2.0F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row {
                Spacer(modifier = Modifier.padding(start = screenWidth * .055f))
                Image(
                    painter = painterResource(R.drawable.girlnobg), contentDescription = "Girl",
                    modifier = Modifier
                        .size(width = screenWidth * 1.1f, height = screenHeight * 0.55f)
                        .zIndex(2.0F)
                        .padding(top = screenHeight * 0.15f), alignment = Alignment.TopStart
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight * 0.45f)
                    .zIndex(3.0F)
                    .shadow(5.dp),
                colors = CardDefaults.cardColors(Color.Transparent),
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color.Black, Color(0xFF13111E))
                            )
                        )
                        .shadow(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(screenWidth * 0.09f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(25.dp))
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp
                                    )
                                ) {
                                    append("From the ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color(0xFF41C3D6),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp
                                    )
                                ) {
                                    append("latest")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp
                                    )
                                ) {
                                    append(" to the ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color(0xFF41C3D6),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp
                                    )
                                ) {
                                    append("greatest")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp
                                    )
                                ) {
                                    append(" hits, play your favourite tracks on ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color(0xFF41C3D6),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp
                                    )
                                ) {
                                    append("Playerio ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 24.sp
                                    )
                                ) {
                                    append("now! ")
                                }
                            },
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        LinearProgressIndicator(
                            progress = {
                                0.6f
                            },
                            modifier = Modifier
                                .height(7.dp)
                                .width(screenWidth * 0.25f),
                            color = Color(0xFF00BCD4),
                            trackColor = Color.White.copy(alpha = 0.3f),
                            gapSize = (-5).dp,
                            drawStopIndicator = {
                            }
                        )
                        Spacer(modifier = Modifier.height(35.dp))
                        ElevatedButton(
                            onClick = { navController.navigate(PlayerioScreens.SignInScreen.name) },
                            modifier = Modifier
                                .width(screenWidth * 0.69f)
                                .height(50.dp)
                                .drawBehind {
                                    val cornerRadius = 25.dp.toPx()
                                    val glowRadius = 8.dp.toPx()

                                    val maxLayers = 6
                                    for (i in 1..maxLayers) {
                                        val layerAlpha = 0.25f * exp(-0.6f * i)

                                        drawRoundRect(
                                            color = Color(0xFF00BCD4).copy(alpha = layerAlpha),
                                            size = Size(
                                                size.width + (i * glowRadius),
                                                size.height + (i * glowRadius)
                                            ),
                                            topLeft = Offset(
                                                -(i * glowRadius / 2),
                                                -(i * glowRadius / 2)
                                            ),
                                            cornerRadius = CornerRadius(cornerRadius + (i * 2.dp.toPx()))
                                        )
                                    }
                                },
                            colors = ButtonDefaults.elevatedButtonColors(
                                containerColor = Color(0xFF00BCD4)
                            ),
                            elevation = ButtonDefaults.buttonElevation(5.dp),
                            shape = RoundedCornerShape(25.dp)
                        ) {
                            Text(
                                text = "Get Started",
                                fontSize = 16.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
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