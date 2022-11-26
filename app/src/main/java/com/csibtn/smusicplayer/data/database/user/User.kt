package com.csibtn.smusicplayer.data.database.user

data class User(
    val userName: String,
    val bio: String = "",
    val userIcon: String = "",
)