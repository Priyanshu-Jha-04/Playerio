// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    kotlin("kapt") version "2.1.20"


    //Firebase
    id("com.google.gms.google-services") version "4.4.2" apply false
    //Dagger Hilt
    id("com.google.dagger.hilt.android") version "2.56.1" apply false

}
buildscript {

    dependencies {
        classpath ("com.android.tools.build:gradle:8.10.0") // Update as needed
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.20")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.56.1")
        classpath(libs.secrets.gradle.plugin)
    }
}