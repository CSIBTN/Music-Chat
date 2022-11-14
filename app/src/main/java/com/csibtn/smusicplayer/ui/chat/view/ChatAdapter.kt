package com.csibtn.smusicplayer.ui.chat.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csibtn.smusicplayer.databinding.ChatItemBinding

class ChatAdapter(private val chatList: List<String>) :
    RecyclerView.Adapter<ChatAdapter.ChatHolder>() {

    inner class ChatHolder(itemBinding: ChatItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(chat: String) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ChatItemBinding.inflate(layoutInflater, parent, false)
        return ChatHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        holder.bind(chatList[position])
    }

    override fun getItemCount(): Int = chatList.size

}
