package com.csibtn.smusicplayer.ui.login.view

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

interface Authenticator {
    suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit
    )

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit
    )
}

class FirebaseAuthenticator : Authenticator {
    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit
    ) {
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onSuccessCallback()
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
        Firebase.auth.signInWithEmailAndPassword(email, password)
    }

}