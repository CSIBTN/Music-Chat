package com.csibtn.smusicplayer.ui.chat.presenter

import android.content.Context
import android.view.View
import com.csibtn.smusicplayer.data.database.ChatsRepository
import com.csibtn.smusicplayer.ui.base.presenter.BasePresenter
import com.csibtn.smusicplayer.ui.chat.ChatsContract

class ChatsPresenterImpl : ChatsContract.ChatsPresenter, BasePresenter {
    private var chatsView: View? = null
    private val chatsRepository = ChatsRepository
    override suspend fun getChats(context: Context) = chatsRepository.fetchAllChats(context)

    override fun onAttachView(view: View) {
        chatsView = view
    }

    override fun onDetachView() {
        chatsView = null
    }
}