package com.csibtn.smusicplayer.ui.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.csibtn.smusicplayer.databinding.FragmentLoginBinding
import com.csibtn.smusicplayer.ui.main.view.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment() : Fragment() {

    @Inject
    lateinit var auth: Authenticator
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = checkNotNull(_binding) {
            "Something went wrong with the view for the login fragment!"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val parentActivity = activity as (MainActivity)
        parentActivity.switchOffTheMenu()
        addListeners()
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    private fun addListeners() {
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.registerUser()
            )
        }
    }
}