package com.csibtn.smusicplayer.data.database.user

data class MessageList(
    val name: String,
    val lastMessage: String,
    private val numOfUnseenMessages: Int,
)