package com.example.playerio.navigation


enum class PlayerioScreens {
    SplashScreen,
    LandingScreen01,
    LandingScreen02,
    LandingScreen03,
    SignUpScreen,
    SignInScreen,
    HomeScreen,
    PlayingScreen,
    SettingsScreen;

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
            SettingsScreen.name -> SettingsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}