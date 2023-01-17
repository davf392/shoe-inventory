package com.idplus.shoestoreinventory.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.idplus.shoestoreinventory.R
import com.idplus.shoestoreinventory.ShoesListAdapter
import com.idplus.shoestoreinventory.databinding.FragmentListingBinding
import com.idplus.shoestoreinventory.model.ShoesViewModel


class ListingFragment : Fragment() {

    private val TAG = this@ListingFragment.javaClass.simpleName
    lateinit var navController: NavController
    private var binding: FragmentListingBinding? = null
    private val sharedViewModel: ShoesViewModel by activityViewModels()
    private var shoesAdapter: ShoesListAdapter  = ShoesListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentBinding = FragmentListingBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        val adapter = ShoesListAdapter()

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            fragmentListing = this@ListingFragment
            recyclerShoesList.adapter = adapter
        }

        sharedViewModel.observeLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, "view was updated according to the data observed in the viewmodel")
            adapter.setShoesData(it)
        }
    }

    fun goToAddNewShoesScreen() = navController.navigate(R.id.action_listingFragment_to_detailFragment)
}