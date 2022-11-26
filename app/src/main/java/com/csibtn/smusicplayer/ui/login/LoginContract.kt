package com.csibtn.smusicplayer.ui.login

import com.csibtn.smusicplayer.ui.base.presenter.BasePresenter
import com.csibtn.smusicplayer.ui.base.view.BaseMVPView

interface LoginContract {
    interface LoginMVPView : BaseMVPView{
        fun showChatIfLoggedIn()
    }

    interface LoginPresenter : BasePresenter {
        suspend fun signIn(
            email: String,
            password: String,
            onSuccessCallback: () -> Unit,
            onFailedCallback: () -> Unit
        )

        suspend fun checkIfLoggedIn(): Boolean
    }

    interface LoginRepository {
        suspend fun signIn(
            email: String,
            password: String,
            onSuccessCallback: () -> Unit,
            onFailedCallback: () -> Unit
        )
        suspend fun checkIfLoggedIn(): Boolean

    }
}