package com.csibtn.smusicplayer.ui.login.register

import android.view.View

interface RegisterContract {
    interface RegisterMVPView {

    }

    interface RegisterPresenter {
        suspend fun signUpUser(
            email: String,
            password: String,
            onSuccessCallback: () -> Unit,
            onFailureCallback: () -> Unit
        )

        fun onAttachView(view: View)
        fun onDetachView()
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