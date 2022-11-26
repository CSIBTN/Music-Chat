package com.csibtn.smusicplayer.ui.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.csibtn.smusicplayer.databinding.FragmentLoginBinding
import com.csibtn.smusicplayer.ui.login.LoginContract
import com.csibtn.smusicplayer.ui.login.presenter.LoginPresenterImpl
import com.csibtn.smusicplayer.ui.login.register.view.RegisterFragmentDirections
import com.csibtn.smusicplayer.ui.main.view.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LoginFragment() : Fragment(), LoginContract.LoginMVPView {


    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = checkNotNull(_binding) {
            "Something went wrong with the view for the login fragment!"
        }
    private val loginPresenter: LoginContract.LoginPresenter = LoginPresenterImpl()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            showChatIfLoggedIn()
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val parentActivity = activity as (MainActivity)
        parentActivity.switchOffTheMenu()
        activity?.actionBar?.hide()
        addListeners()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginPresenter.onAttachView(requireView())
    }


    override fun addListeners() {
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.registerUser()
            )
        }
        binding.btnSignIn.setOnClickListener {
            val email = binding.tiEmail.editText?.text.toString()
            val password = binding.tiPassword.editText?.text.toString()
            viewLifecycleOwner.lifecycleScope.launch {
                loginPresenter.signIn(email, password, {
                    findNavController().navigate(
                        RegisterFragmentDirections.openChat()
                    )
                },
                    {
                        Toast.makeText(
                            context,
                            "LOGIN HAVE FAILED!",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.onDetachView()
        _binding = null
    }

    override fun showChatIfLoggedIn() {
        viewLifecycleOwner.lifecycleScope.launch {
            val value = loginPresenter.checkIfLoggedIn()
            if (value) {
                findNavController().navigate(
                    RegisterFragmentDirections.openChat()
                )
            }
        }
    }
}