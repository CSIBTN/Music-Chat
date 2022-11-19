package com.csibtn.smusicplayer.ui.login.register

import com.csibtn.smusicplayer.ui.base.presenter.BasePresenter

interface RegisterContract {
    interface RegisterMVPView {

    }

    interface RegisterPresenter : BasePresenter {
        suspend fun signUpUser(
            email: String,
            password: String,
            onSuccessCallback: () -> Unit,
            onFailureCallback: () -> Unit
        )
    }

    interface RegisterRepository {
        suspend fun createUser(
            email: String,
            password: String,
            onSuccessCallback: () -> Unit,
            onFailureCallback: () -> Unit
        )
    }
}