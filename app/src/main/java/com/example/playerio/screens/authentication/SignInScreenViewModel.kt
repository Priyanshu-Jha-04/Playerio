package com.example.playerio.screens.authentication

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

//class SignInScreenViewModel : ViewModel() {
//    // val loadingState = MutableStateFlow(LoadingState.IDLE)
//    private val auth: FirebaseAuth = Firebase.auth
//
//    private val _loading = MutableLiveData(false)
//    val loading: LiveData<Boolean> = _loading
//
//    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) = viewModelScope.launch {
//        try {
//            auth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        Log.d("FB", "createUserWithEmailAndPassword: ${task.result.toString()}")
//                        home()
//                    } else {
//                        Log.d("FB", "createUserWithEmailAndPassword: ${task.result.toString()}")
//                    }
//                }
//        } catch (ex: Exception) {
//            Log.d("FB", "createUserWithEmailAndPassword: ${ex.message}")
//        }
//    }
//}

class SignInScreenViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error

    private val _isUserSignedIn = MutableLiveData<Boolean>()
    val isUserSignedIn: LiveData<Boolean> = _isUserSignedIn

    init {
        checkAuthenticationState()
    }

    private fun checkAuthenticationState() {
        _isUserSignedIn.value = auth.currentUser != null
    }

    fun clearError() {
        _error.value = null
    }

    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) = viewModelScope.launch {
        if (email.isBlank() || password.isBlank()) {
            _error.value = "Email and password cannot be empty"
            return@launch
        }

        _loading.value = true
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    _loading.value = false
                    if (task.isSuccessful) {
                        Log.d("FB", "signInWithEmailAndPassword: Success")
                        home()
                    } else {
                        val errorMessage = task.exception?.message ?: "Authentication failed"
                        Log.e("FB", "signInWithEmailAndPassword: $errorMessage")
                        _error.value = errorMessage
                    }
                }
        } catch (ex: Exception) {
            _loading.value = false
            Log.e("FB", "signInWithEmailAndPassword exception: ${ex.message}")
            _error.value = ex.message ?: "Unknown error occurred"
        }
    }
    fun createUserWithEmailAndPassword(email: String, password: String, home: () -> Unit) = viewModelScope.launch {
        if (email.isBlank() || password.isBlank()) {
            _error.value = "Email and password cannot be empty"
            return@launch
        }

        if (password.length < 6) {
            _error.value = "Password must be at least 6 characters"
            return@launch
        }

        _loading.value = true
        try {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    _loading.value = false
                    if (task.isSuccessful) {
                        Log.d("FB", "createUserWithEmailAndPassword: Success")
                        val user = auth.currentUser
                        Log.d("FB", "User created: ${user?.email}")
                        home()
                    } else {
                        val errorMessage = task.exception?.message ?: "Account creation failed"
                        Log.e("FB", "createUserWithEmailAndPassword: $errorMessage")
                        _error.value = errorMessage
                    }
                }
        } catch (ex: Exception) {
            _loading.value = false
            Log.e("FB", "createUserWithEmailAndPassword exception: ${ex.message}")
            _error.value = ex.message ?: "Unknown error occurred"
        }
    }

}
