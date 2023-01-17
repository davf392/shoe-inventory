package com.idplus.shoestoreinventory.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.idplus.shoestoreinventory.R
import com.idplus.shoestoreinventory.databinding.FragmentDetailBinding
import com.idplus.shoestoreinventory.model.ShoesViewModel


class DetailFragment : Fragment() {

    lateinit var navController: NavController
    private val sharedViewModel: ShoesViewModel by activityViewModels()
    private var binding: FragmentDetailBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentBinding = FragmentDetailBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        binding?.apply {
            fragmentDetail = this@DetailFragment
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    fun goToShoesListScreen() {
        // add the pair of shoes to the shared view model
        sharedViewModel.addPairOfShoes()

        // clear fields for next time
        binding?.apply {
            companyName.setText("")
            shoeName.setText("")
            shoeSize.setText("")
            description.setText("")
        }
        Toast.makeText(context,"Added", Toast.LENGTH_SHORT).show()

        // go to the fragment that displays the entire list
        navController.navigate(R.id.action_detailFragment_to_listingFragment)
    }

    fun goToPreviousScreen() {
        Toast.makeText(context,"Cancelled.",Toast.LENGTH_SHORT).show()
        requireActivity().onBackPressed()
    }
}


