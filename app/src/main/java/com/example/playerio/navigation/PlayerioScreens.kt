package com.example.playerio.navigation

import com.example.playerio.screens.library.LibraryScreen
import okhttp3.internal.notifyAll


enum class PlayerioScreens {
    AuthCheck,
    SplashScreen,
    LandingScreen01,
    LandingScreen02,
    LandingScreen03,
    SignUpScreen,
    SignInScreen,
    HomeScreen,
    PlayingScreen,
    LibraryScreen,
    MainScreen,
    SearchScreen;

    companion object {
        fun fromRoute(route: String): PlayerioScreens
        = when(route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            LandingScreen01.name -> LandingScreen01
            LandingScreen02.name -> LandingScreen02
            LandingScreen03.name -> LandingScreen03
            SignUpScreen.name -> SignUpScreen
            SignInScreen.name -> SignInScreen
            HomeScreen.name -> HomeScreen
            PlayingScreen.name -> PlayingScreen
            LibraryScreen.name -> LibraryScreen
            SearchScreen.name -> SearchScreen
            MainScreen.name -> MainScreen
            AuthCheck.name -> AuthCheck
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}