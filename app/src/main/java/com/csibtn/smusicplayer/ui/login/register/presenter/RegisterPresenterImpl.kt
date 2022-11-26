package com.csibtn.smusicplayer.ui.login.register.presenter

import android.view.View
import com.csibtn.smusicplayer.data.database.AuthRepository
import com.csibtn.smusicplayer.ui.login.register.RegisterContract
import com.csibtn.smusicplayer.ui.login.register.view.RegisterFragment


class RegisterPresenterImpl : RegisterContract.RegisterPresenter {

    private var registerView: View? = null
    private val registerRepository: RegisterContract.RegisterRepository = AuthRepository

    override suspend fun signUpUser(
        email: String,
        password: String,
        userName: String,
        onSuccessCallback: () -> Unit,
        onFailureCallback: () -> Unit,
        fragment: RegisterFragment
    ) {
        registerRepository.createUser(
            email,
            password,
            userName,
            onSuccessCallback,
            onFailureCallback,
            fragment
        )
    }

    override fun onAttachView(view: View) {
        registerView = view
    }

    override fun onDetachView() {
        registerView = null
    }

}