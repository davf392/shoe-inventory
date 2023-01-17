package com.idplus.shoestoreinventory.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.idplus.shoestoreinventory.R
import com.idplus.shoestoreinventory.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var navController: NavController
    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentBinding = FragmentLoginBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        binding?.fragmentLogin = this@LoginFragment
    }

    fun accountLoginOrSignUp() {
        binding?.apply {
            if(!editEmail.text.isNullOrEmpty() || !editPassword.text.isNullOrEmpty())
                navController.navigate(R.id.action_loginFragment_to_welcomeFragment)
            else
                Toast.makeText(requireContext(), "Please enter a valid username & password", Toast.LENGTH_SHORT).show()
        }
    }
}