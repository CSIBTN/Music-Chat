package com.csibtn.smusicplayer.ui.chat

import android.content.Context
import com.csibtn.smusicplayer.data.database.user.User
import com.csibtn.smusicplayer.ui.base.presenter.BasePresenter
import com.csibtn.smusicplayer.ui.base.view.BaseMVPView

interface ChatsContract {
    interface ChatsMVPView : BaseMVPView {

    }

    interface ChatsPresenter : BasePresenter {
        suspend fun getChats(context: Context) : List <User>
    }

    interface ChatsRepository {
        suspend fun fetchAllChats(context: Context): List<User>
    }

}