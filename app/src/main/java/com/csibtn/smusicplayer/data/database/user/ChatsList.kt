package com.csibtn.smusicplayer.data.database.user

data class ChatsList(
    val name: String,
    val lastMessage: String,
    private val numOfUnseenMessages: Int,
    private val timeStamp : String,
    private val chatMatePhoto : String
)