package com.csibtn.smusicplayer.data.database

import android.content.Context
import com.csibtn.smusicplayer.data.database.user.User
import com.csibtn.smusicplayer.data.database.user.UserDatabase
import com.csibtn.smusicplayer.ui.chat.ChatsContract
import com.csibtn.smusicplayer.ui.login.view.FirebaseAuthenticator

object ChatsRepository : ChatsContract.ChatsRepository {
    private val databaseChats = UserDatabase
    private val authenticator = FirebaseAuthenticator

    override suspend fun fetchAllChats(context: Context): List<User> {
        return databaseChats.getAllUsers(authenticator.currentUserId()!!, context)
    }

}