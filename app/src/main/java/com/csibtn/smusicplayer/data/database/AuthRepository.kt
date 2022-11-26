package com.csibtn.smusicplayer.data.database

import com.csibtn.smusicplayer.ui.login.LoginContract
import com.csibtn.smusicplayer.ui.login.register.RegisterContract
import com.csibtn.smusicplayer.ui.login.register.view.RegisterFragment
import com.csibtn.smusicplayer.ui.login.view.Authenticator
import com.csibtn.smusicplayer.ui.login.view.FirebaseAuthenticator


object AuthRepository :
    RegisterContract.RegisterRepository, LoginContract.LoginRepository {
    private val authenticator: Authenticator = FirebaseAuthenticator

    override suspend fun createUser(
        email: String,
        password: String,
        userName: String,
        onSuccessCallback: () -> Unit,
        onFailureCallback: () -> Unit,
        fragment: RegisterFragment
    ) {
        authenticator.createUserWithEmailAndPassword(
            email,
            password,
            userName,
            onSuccessCallback,
            onFailureCallback,
            fragment,
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

    override suspend fun checkIfLoggedIn(): Boolean {
        return authenticator.checkIfLoggedIn()
    }
}