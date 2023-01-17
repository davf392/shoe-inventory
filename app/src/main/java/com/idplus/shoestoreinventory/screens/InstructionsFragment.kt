package com.idplus.shoestoreinventory.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.idplus.shoestoreinventory.R
import com.idplus.shoestoreinventory.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {

    lateinit var navController: NavController
    private var binding: FragmentInstructionsBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentBinding = FragmentInstructionsBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        binding?.fragmentInstructions = this@InstructionsFragment
    }

    fun goToShoesListScreen() = navController.navigate(R.id.action_instructionsFragment_to_listingFragment)

    fun goToAddNewShoeScreen() = navController.navigate(R.id.action_instructionsFragment_to_detailFragment)
}