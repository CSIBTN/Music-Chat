package com.csibtn.smusicplayer.ui.login.view

import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.csibtn.smusicplayer.data.database.user.UserDatabase
import com.csibtn.smusicplayer.ui.login.register.view.RegisterFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

interface Authenticator {
    suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        userName: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit,
        fragment: RegisterFragment
    )

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit
    )

    suspend fun checkIfLoggedIn(): Boolean
}

object FirebaseAuthenticator : Authenticator {
    private val auth: FirebaseAuth = Firebase.auth
    private val userDatabase: UserDatabase = UserDatabase

    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        userName: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit,
        fragment: RegisterFragment,
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onSuccessCallback()
                    auth.currentUser?.uid?.let {
                        fragment.viewLifecycleOwner.lifecycleScope.launch {
                            userDatabase.addUser(it, userName)
                        }
                    }
                } else {
                    onFailedCallback()
                }
            }
    }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccessCallback()
            } else {
                onFailedCallback()
            }
        }
    }

    override suspend fun checkIfLoggedIn(): Boolean {
        if (auth.currentUser?.uid != null){
            Log.d("CRINGE", auth.currentUser?.uid.toString())
            return userDatabase.isUserPresent(auth.currentUser?.uid)
        }
        return false
    }

    suspend fun currentUserId(): String? {
        return auth.currentUser?.uid
    }

}