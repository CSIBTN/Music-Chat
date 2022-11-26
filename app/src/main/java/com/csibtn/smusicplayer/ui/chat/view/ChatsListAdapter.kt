package com.csibtn.smusicplayer.ui.chat.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.csibtn.smusicplayer.data.database.user.User
import com.csibtn.smusicplayer.databinding.ChatsItemBinding

class ChatsListAdapter(private val chatList: List<User>, private val fragmentContext: Context) :
    RecyclerView.Adapter<ChatsListAdapter.ChatHolder>() {

    inner class ChatHolder(private val itemBinding: ChatsItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(chat: User) {
            Log.d("CRINGE", chat.userIcon)
            Glide
                .with(fragmentContext)
                .load(chat.userIcon)
                .centerCrop()
                .into(itemBinding.ivChatMateIcon)
            itemBinding.tvChatMateName.text = chat.userName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ChatsItemBinding.inflate(layoutInflater, parent, false)
        Log.d("CRINGE", chatList.size.toString())
        return ChatHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        holder.bind(chatList[position])
    }

    override fun getItemCount(): Int = chatList.size

}
