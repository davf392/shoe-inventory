package com.idplus.shoestoreinventory.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.idplus.shoestoreinventory.R
import com.idplus.shoestoreinventory.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    lateinit var navController: NavController
    private var binding: FragmentWelcomeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentBinding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        binding?.fragmentWelcome = this@WelcomeFragment
    }

    fun goToNextScreen() {
        navController.navigate(R.id.action_welcomeFragment_to_instructionsFragment)
    }
}