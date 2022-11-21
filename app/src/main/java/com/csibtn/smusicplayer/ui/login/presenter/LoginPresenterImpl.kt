package com.csibtn.smusicplayer.ui.login.presenter

import android.view.View
import com.csibtn.smusicplayer.data.database.AuthRepository
import com.csibtn.smusicplayer.ui.login.LoginContract

class LoginPresenterImpl : LoginContract.LoginPresenter {

    private var loginView: View? = null
    private var loginRepository: LoginContract.LoginRepository = AuthRepository

    override suspend fun signIn(
        email: String,
        password: String,
        onSuccessCallback: () -> Unit,
        onFailedCallback: () -> Unit
    ) {
        loginRepository.signIn(email, password, onSuccessCallback, onFailedCallback)
    }

    override suspend fun checkIfLoggedIn(): Boolean {
        return loginRepository.checkIfLoggedIn();
    }

    override fun onAttachView(view: View) {
        loginView = view
    }

    override fun onDetachView() {
        loginView = null
    }
}