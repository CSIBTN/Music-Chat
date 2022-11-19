package com.csibtn.smusicplayer.data.database

import com.csibtn.smusicplayer.ui.login.LoginContract
import com.csibtn.smusicplayer.ui.login.register.RegisterContract
import com.csibtn.smusicplayer.ui.login.view.Authenticator
import com.csibtn.smusicplayer.ui.login.view.FirebaseAuthenticator


object DatabaseRepository :
    RegisterContract.RegisterRepository, LoginContract.LoginRepository {
    private val authenticator: Authenticator = FirebaseAuthenticator()

    override suspend fun createUser(
        email: String,
        password: String,
        onSuccessCallback: () -> Unit,
        onFailureCallback: () -> Unit
    ) {
        authenticator.createUserWithEmailAndPassword(
            email,
            password,
            onSuccessCallback,
            onFailureCallback
        )
    }

    override suspend fun signIn(
        email: String,
        password: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit
    ) {
        authenticator.signInWithEmailAndPassword(
            email,
            password,
            onSuccessCallback,
            onFailedCallback
        )
    }
}