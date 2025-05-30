package com.example.playerio.screens.authentication

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.playerio.R
import com.example.playerio.navigation.PlayerioScreens
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun SignInScreen(navController: NavController, viewModel: SignInScreenViewModel = viewModel()) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    var email = rememberSaveable { mutableStateOf("") }
    var password = rememberSaveable { mutableStateOf("") }
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }
    val emailFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }
    // val isSignInEnabled = email.value.isNotBlank() && password.value.length >= 8
    val context = LocalContext.current
    val error by viewModel.error.observeAsState()
    val isLoading by viewModel.loading.observeAsState(false)

    error?.let { errorMessage ->
        LaunchedEffect(errorMessage) {
            val displayMessage = when {
                errorMessage.contains("password is invalid", ignoreCase = true) ->
                    "Wrong password. Please try again."

                errorMessage.contains("no user record", ignoreCase = true) ||
                        errorMessage.contains("user not found", ignoreCase = true) ->
                    "No account found with this email."

                errorMessage.contains("invalid-email", ignoreCase = true) ->
                    "Invalid email format."

                errorMessage.contains("too-many-requests", ignoreCase = true) ->
                    "Too many failed attempts. Please try again later."

                else -> "Login failed. Please check your credentials."
            }
            Toast.makeText(context, displayMessage, Toast.LENGTH_LONG).show()
            viewModel.clearError()
        }
    }

    LaunchedEffect(Firebase.auth.currentUser) {
        Firebase.auth.currentUser?.let {
            Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF240B48)
    )
    {
        Image(
            painter = painterResource(R.drawable.authbg),
            contentDescription = null,
            alignment = Alignment.TopEnd,
            modifier = Modifier
                .size(height = screenHeight * 0.55f, width = screenWidth)
                .zIndex(2.0f)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(3.0f)
        ) {
            Spacer(modifier = Modifier.height(screenHeight * 0.35f))
            Text(
                "SIGN IN",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                modifier = Modifier.padding(start = screenWidth * 0.08f)
            )
            Spacer(modifier = Modifier.height(screenHeight * 0.02f))
            Text(
                "Sign In with email address",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = screenWidth * 0.09f)
            )

            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon",
                        tint = Color.White
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF190733),
                    unfocusedContainerColor = Color(0xFF190733),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                modifier = Modifier
                    .padding(
                        start = screenWidth * 0.07f,
                        top = 10.dp,
                        end = screenWidth * 0.07f
                    )
                    .width(screenWidth),
                placeholder = {
                    Text(
                        text = "YourName@gmail.com",
                        color = Color.White.copy(alpha = 0.7f)
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )
            Text(
                "Enter Password",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = screenWidth * 0.09f, top = 20.dp)
            )
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Email Icon",
                        tint = Color.White
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {
                        Icon(
                            imageVector = if (passwordVisibility.value) Icons.Default.Visibility
                            else Icons.Default.VisibilityOff,
                            contentDescription = "Toggle Password Visibility",
                            tint = Color.White
                        )
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF190733),
                    unfocusedContainerColor = Color(0xFF190733),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                modifier = Modifier
                    .padding(
                        start = screenWidth * 0.07f,
                        top = 10.dp,
                        end = screenWidth * 0.07f
                    )
                    .width(screenWidth),
                placeholder = {
                    Text(
                        text = "Password",
                        color = Color.White.copy(alpha = 0.7f)
                    )
                },
                singleLine = true,
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )
            Spacer(modifier = Modifier.height(screenHeight * 0.02f))

            ElevatedButton(
                onClick = {
                    val emailText = email.value.trim()
                    val passwordText = password.value.trim()

                    when {
                        emailText.isBlank() -> {
                            Toast.makeText(context, "Email cannot be empty", Toast.LENGTH_SHORT)
                                .show()
                        }

                        passwordText.isBlank() -> {
                            Toast.makeText(context, "Password cannot be empty", Toast.LENGTH_SHORT)
                                .show()
                        }

                        passwordText.length < 6 -> {
                            Toast.makeText(
                                context,
                                "Password must be at least 6 characters",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        else -> {
                            Log.d(
                                "SignIn",
                                "Email: '$emailText', Password length: ${passwordText.length}"
                            )
                            viewModel.signInWithEmailAndPassword(emailText, passwordText) {
                                navController.navigate(PlayerioScreens.MainScreen.name)
                            }
                        }
                    }
                },
                modifier = Modifier
                    .width(screenWidth * 0.69f)
                    .height(50.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF501794),
                                Color(0xFF3E70A1)
                            )
                        ),
                        shape = RoundedCornerShape(23.dp)
                    )
                    .align(alignment = Alignment.CenterHorizontally),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Color.Transparent
                ),
                shape = RoundedCornerShape(25.dp),
                enabled = !isLoading
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        color = Color.White,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text(
                        text = "Sign In",
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }


            HorizontalDivider(
                modifier = Modifier
                    .padding(
                        top = screenHeight * 0.02f,
                        start = screenHeight * 0.02f,
                        end = screenHeight * 0.02f
                    )
                    .alpha(0.5f),
                thickness = 2.dp,
                color = Color(0xFF727272)
            )
            Spacer(modifier = Modifier.height(screenHeight * 0.02f))
            Text(
                "Or continue with",
                color = Color(0xFFB6B6B6),
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = screenWidth * 0.06f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ElevatedButton(
                    onClick = { /* Handle Google login */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = Color(0xFF3B2063)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.googlelogo),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .height(15.dp)
                                .width(15.dp)
                        )
                        Text(
                            text = "Google",
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
                ElevatedButton(
                    onClick = { /* Handle Facebook login */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = Color(0xFF3B2063)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.fblogo),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .height(18.dp)
                                .width(18.dp)
                        )
                        Text(
                            text = "Facebook",
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
            Row() {
                Text(
                    "By signing in you agree with our",
                    color = Color(0xFFB6B6B6),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = screenWidth * 0.05f)
                )
                Text(
                    " Terms and Condition.",
                    color = Color(0xFF9D5CE9),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                    navController.navigate(PlayerioScreens.SignUpScreen.name) {
                        popUpTo(PlayerioScreens.SignInScreen.name) { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Row {
                    Text(
                        "Don't have an Account?",
                        color = Color(0XFFA4A4A4),
                        fontSize = (screenWidth * 0.04f).value.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Default
                    )
                    Text(
                        text = " Sign Up",
                        color = Color.LightGray,
                        fontSize = (screenWidth * 0.04f).value.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Default
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    val navController = rememberNavController()
    SignInScreen(navController = navController)
}