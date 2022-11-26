package com.csibtn.smusicplayer.ui.login.register

import com.csibtn.smusicplayer.ui.base.presenter.BasePresenter
import com.csibtn.smusicplayer.ui.base.view.BaseMVPView
import com.csibtn.smusicplayer.ui.login.register.view.RegisterFragment

interface RegisterContract {
    interface RegisterMVPView : BaseMVPView{

    }

    interface RegisterPresenter : BasePresenter {
        suspend fun signUpUser(
            email: String,
            password: String,
            userName: String,
            onSuccessCallback: () -> Unit,
            onFailureCallback: () -> Unit,
            fragment: RegisterFragment
        )
    }

    interface RegisterRepository {
        suspend fun createUser(
            email: String,
            password: String,
            userName : String,
            onSuccessCallback: () -> Unit,
            onFailureCallback: () -> Unit,
            fragment: RegisterFragment
        )
    }
}