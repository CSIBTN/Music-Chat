package com.csibtn.smusicplayer.ui.login.view

import com.csibtn.smusicplayer.data.database.user.UserDatabase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

interface Authenticator {
    suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        userName: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit
    )

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit
    )
    suspend fun checkIfLoggedIn() : Boolean
}

class FirebaseAuthenticator : Authenticator {
    private val auth: FirebaseAuth = Firebase.auth
    private val userDatabase: UserDatabase = UserDatabase

    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        userName: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onSuccessCallback()
                    auth.currentUser?.uid?.let { userDatabase.addUser(it, userName) }
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
        return auth.currentUser != null
    }

}