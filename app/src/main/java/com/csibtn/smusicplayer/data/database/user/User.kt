package com.csibtn.smusicplayer.data.database.user

data class User(
    private val userName: String,
    private val bio: String = "",
    private val userIcon: String = "",
)