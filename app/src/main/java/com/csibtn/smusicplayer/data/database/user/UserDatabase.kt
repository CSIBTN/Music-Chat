package com.csibtn.smusicplayer.data.database.user

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.csibtn.smusicplayer.util.Constants
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay

object UserDatabase {
    private val userDatabase = Firebase.database.reference.child(Constants.userTable)

    suspend fun isUserPresent(userId: String?): Boolean {
        var isPresent = false;
        userDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                isPresent = snapshot.child(userId!!).exists()
            }

            override fun onCancelled(error: DatabaseError) {
                isPresent = false;
            }
        })
        delay(1400L)
        return isPresent
    }

    fun addUser(UID: String, userName: String) {
        userDatabase.child(UID).child("user_name").setValue(userName)
        userDatabase.child(UID).child("bio").setValue("")
        userDatabase.child(UID).child("profile_picture").setValue("")
    }

    fun getAllUsers(userId: String, context: Context): List<User> {
        val userList: MutableList<User> = mutableListOf()
        userDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (user in dataSnapshot.children) {
                    if (userId != user.key) {
                        Log.d("CRINGE", user.key!!)


                        val chatUserName = user.child("user_name").value
                        val userPhoto = user.child("profile_picture").value
                        val userBio = user.child("bio").value

                        Log.d("CRINGE", chatUserName.toString())
                        Log.d("CRINGE", userBio.toString())
                        Log.d("CRINGE", userPhoto.toString())

                        if (chatUserName != null && userBio != null && userPhoto != null)
                            userList.add(
                                User(
                                    chatUserName.toString(),
                                    userBio.toString(),
                                    userPhoto.toString()
                                )
                            )
                        Log.d("CRINGE", userList.size.toString())

                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    context,
                    "Failed to load your chats! We are awfully sorry for this issue.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        return userList
    }
}