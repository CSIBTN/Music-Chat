package com.csibtn.smusicplayer.ui.chat.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.csibtn.smusicplayer.databinding.FragmentChatBinding
import com.csibtn.smusicplayer.ui.base.view.BaseMVPView
import com.csibtn.smusicplayer.ui.main.view.MainActivity

class ChatFragment : Fragment(), BaseMVPView {
    private var _binding: FragmentChatBinding? = null
    private val binding: FragmentChatBinding
        get() = checkNotNull(_binding) {
            "Something went wrong with the view for the chat fragment!"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        switchOnTheMenu()
        return binding.root
    }

    override fun switchOffTheMenu() {
        val parentActivity = activity as (MainActivity)
        parentActivity.switchOffTheMenu()
    }

    override fun switchOnTheMenu() {
        val parentActivity = activity as (MainActivity)
        parentActivity.switchOnTheMenu()
    }
}