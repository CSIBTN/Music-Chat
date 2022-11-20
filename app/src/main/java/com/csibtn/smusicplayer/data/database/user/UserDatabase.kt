package com.csibtn.smusicplayer.data.database.user

import com.csibtn.smusicplayer.util.Constants
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object UserDatabase {
    private val userDatabase = Firebase.database.reference.child(Constants.userTable)

    fun addUser(UID: String, userName: String) {
        userDatabase.child(UID).child("user_name").setValue(userName)
        userDatabase.child(UID).child("bio").setValue("")
        userDatabase.child(UID).child("profile_picture").setValue("")
    }
}