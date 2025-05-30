package com.example.playerio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.playerio.MainScreen
import com.example.playerio.screens.authentication.AuthCheck
import com.example.playerio.screens.authentication.SignInScreen
import com.example.playerio.screens.authentication.SignUpScreen
import com.example.playerio.screens.home.HomeScreen
import com.example.playerio.screens.landing.LandingScreen01
import com.example.playerio.screens.landing.LandingScreen02
import com.example.playerio.screens.landing.LandingScreen03
import com.example.playerio.screens.library.LibraryScreen
import com.example.playerio.screens.playing.PlayingScreen
import com.example.playerio.screens.settings.SearchScreen
import com.example.playerio.screens.splash.SplashScreen

@Composable
fun PlayerioNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = PlayerioScreens.LandingScreen01.name) {
        composable(PlayerioScreens.AuthCheck.name) {
            AuthCheck(navController = navController)
        }
        composable(PlayerioScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(PlayerioScreens.LandingScreen01.name) {
            LandingScreen01(navController = navController)
        }
        composable(PlayerioScreens.LandingScreen02.name) {
            LandingScreen02(navController = navController)
        }
        composable(PlayerioScreens.LandingScreen03.name) {
            LandingScreen03(navController = navController)
        }
        composable(PlayerioScreens.SignUpScreen.name) {
            SignUpScreen(navController = navController)
        }
        composable(PlayerioScreens.SignInScreen.name) {
            SignInScreen(navController = navController)
        }
        composable(PlayerioScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(PlayerioScreens.PlayingScreen.name) {
            PlayingScreen(navController = navController)
        }
        composable(PlayerioScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
        composable(PlayerioScreens.LibraryScreen.name) {
            LibraryScreen(navController = navController)
        }
        composable(PlayerioScreens.MainScreen.name) {
            MainScreen()
        }
    }
}