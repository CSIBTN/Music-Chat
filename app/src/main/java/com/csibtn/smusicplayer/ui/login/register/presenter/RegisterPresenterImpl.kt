package com.csibtn.smusicplayer.ui.login.register.presenter

import android.view.View
import com.csibtn.smusicplayer.data.database.DatabaseRepository
import com.csibtn.smusicplayer.ui.login.register.RegisterContract


class RegisterPresenterImpl : RegisterContract.RegisterPresenter {

    private var registerView: View? = null
    private val registerRepository: RegisterContract.RegisterRepository = DatabaseRepository

    override suspend fun signUpUser(
        email: String,
        password: String,
        onSuccessCallback: () -> Unit,
        onFailureCallback: () -> Unit
    ) {
        registerRepository.createUser(email, password, onSuccessCallback, onFailureCallback)
    }

    override fun onAttachView(view: View) {
        registerView = view
    }

    override fun onDetachView() {
        registerView = null
    }

}