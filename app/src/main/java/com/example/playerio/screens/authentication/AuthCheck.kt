package com.example.playerio.screens.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.playerio.navigation.PlayerioScreens
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun AuthCheck(navController: NavController) {
    val auth = Firebase.auth
    val currentUser = auth.currentUser

    LaunchedEffect(Unit) {
        // Add a small delay for better UX (optional)
        kotlinx.coroutines.delay(1000)

        if (currentUser != null) {
            // User is already signed in, navigate to main screen
            navController.navigate(PlayerioScreens.MainScreen.name) {
                popUpTo(0) { inclusive = true } // Clear entire back stack
            }
        } else {
            // User is not signed in, navigate to sign in screen
            navController.navigate(PlayerioScreens.SignInScreen.name) {
                popUpTo(0) { inclusive = true }
            }
        }
    }

    // Show loading screen while checking
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF240B48)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Loading...",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}
