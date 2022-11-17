package com.csibtn.smusicplayer.ui.login.view

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

interface Authenticator {
    suspend fun createUserWithEmailAndPassword(email: String, password: String)
    suspend fun signInWithEmailAndPassword(email: String, password: String)
}

class FirebaseAuthenticator : Authenticator {
    override suspend fun createUserWithEmailAndPassword(email: String, password: String) {
        Firebase.auth.createUserWithEmailAndPassword(email, password)
    }

    override suspend fun signInWithEmailAndPassword(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
    }

}