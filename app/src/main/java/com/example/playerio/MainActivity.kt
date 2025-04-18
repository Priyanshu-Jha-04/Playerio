package com.example.playerio

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.playerio.navigation.PlayerioNavigation
import com.example.playerio.ui.theme.PlayerioTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }
            setOnExitAnimationListener { screen ->
                val zoomX = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.7f,
                    0.0f
                )
                zoomX.interpolator = OvershootInterpolator()
                zoomX.duration = 500L

                val zoomY = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.7f,
                    0.0f
                )
                zoomY.interpolator = OvershootInterpolator()
                zoomY.duration = 500L
                zoomY.doOnEnd { screen.remove() }

                zoomX.start()
                zoomY.start()
            }
        }
        // UI content
        setContent {
            PlayerioTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PlayerioApp()
                }
            }
        }
    }
}

@Composable
fun PlayerioApp() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PlayerioNavigation()
        }
    }
}


//        Firebase.auth.signInAnonymously()
//            .addOnSuccessListener { result ->
//                val uid = result.user?.uid ?: return@addOnSuccessListener
//                val db = Firebase.firestore
//                val user: MutableMap<String, Any> = HashMap()
//                user["firsName"] = "Priyanshu"
//                user["lastName"] = "Jha"
//
//                db.collection("users").add(user)
//                    .addOnSuccessListener {
//                        Log.d("FB", "User data saved for $uid")
//                    }
//                    .addOnFailureListener {
//                        Log.e("FB", "Write failed: ${it.message}")
//                    }
//            }
//            .addOnFailureListener {
//                Log.e("FB", "Auth failed: ${it.message}")
//            }
