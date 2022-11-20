package com.csibtn.smusicplayer.ui.login.register.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.csibtn.smusicplayer.databinding.FragmentRegisterBinding
import com.csibtn.smusicplayer.ui.login.register.RegisterContract
import com.csibtn.smusicplayer.ui.login.register.presenter.RegisterPresenterImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : Fragment(), RegisterContract.RegisterMVPView {

    private var _binding: FragmentRegisterBinding? = null
    private val binding: FragmentRegisterBinding
        get() = checkNotNull(_binding) {
            "Something went wrong with the view for the login fragment!"
        }

    private val registerPresenter = RegisterPresenterImpl()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        addListeners()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerPresenter.onAttachView(requireView())
    }


    override fun onDestroy() {
        super.onDestroy()
        registerPresenter.onDetachView()
        _binding = null
    }

    private fun addListeners() {
        binding.btnSignUp.setOnClickListener() {

            val email = binding.tiEmail.editText?.text.toString()
            val password = binding.tiPassword.editText?.text.toString()
            val userName = binding.tiLogin.editText?.text.toString()

            viewLifecycleOwner.lifecycleScope.launch {
                registerPresenter.signUpUser(email, password, userName,
                    {
                        findNavController().navigate(
                            RegisterFragmentDirections.openChat()
                        )
                    },
                    {
                        Toast.makeText(
                            context,
                            "REGISTRATION HAVE FAILED!",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
            }
        }
    }
}