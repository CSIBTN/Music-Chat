package com.csibtn.smusicplayer.ui.chat.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.csibtn.smusicplayer.databinding.FragmentChatsBinding
import com.csibtn.smusicplayer.ui.chat.ChatsContract
import com.csibtn.smusicplayer.ui.chat.presenter.ChatsPresenterImpl
import com.csibtn.smusicplayer.ui.main.view.MainActivity
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChatsFragment : Fragment(), ChatsContract.ChatsMVPView {
    private var _binding: FragmentChatsBinding? = null
    private val binding: FragmentChatsBinding
        get() = checkNotNull(_binding) {
            "Something went wrong with the view for the chat fragment!"
        }

    private val chatPresenter: ChatsContract.ChatsPresenter = ChatsPresenterImpl()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        binding.rvChatsList.layoutManager = LinearLayoutManager(context)
        switchOnTheMenu()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        chatPresenter.onAttachView(requireView())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        chatPresenter.onDetachView()
    }

    override fun addListeners() {

    }

    private fun setAdapter() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                val chats = chatPresenter.getChats(requireContext())
                delay(1000L)
                binding.rvChatsList.adapter = ChatsListAdapter(chats, requireContext())
            }
        }
    }

    private fun switchOnTheMenu() {
        val parentActivity = activity as (MainActivity)
        parentActivity.switchOnTheMenu()
    }


}