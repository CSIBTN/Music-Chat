package com.csibtn.smusicplayer.ui.login

import com.csibtn.smusicplayer.ui.base.presenter.BasePresenter

interface LoginContract {
    interface LoginMVPView {

    }

    interface LoginPresenter  : BasePresenter{
        suspend fun signIn(
            email: String,
            password: String,
            onSuccessCallback: () -> Unit,
            onFailedCallback: () -> Unit
        )
    }

    interface LoginRepository {
        suspend fun signIn(
            email: String,
            password: String,
            onSuccessCallback: () -> Unit,
            onFailedCallback: () -> Unit
        )
    }
}