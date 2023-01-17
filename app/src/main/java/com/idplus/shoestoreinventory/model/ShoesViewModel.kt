package com.idplus.shoestoreinventory.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel: ViewModel() {

    private val TAG: String? = this@ShoesViewModel.javaClass.simpleName

    private val _shoesList = MutableLiveData<MutableList<PairOfShoes>>()
    val shoesList: LiveData<MutableList<PairOfShoes>> get() =_shoesList

    var shoesName : MutableLiveData<String> = MutableLiveData()
    var companyName : MutableLiveData<String> = MutableLiveData()
    var shoesSize : MutableLiveData<String> = MutableLiveData()
    var description : MutableLiveData<String> = MutableLiveData()


    init {
        initializeListOfShoes()
    }

    private fun initializeListOfShoes() {
        Log.d(TAG, "initializing list of shoes in the view model")

        _shoesList.value = mutableListOf(
            PairOfShoes("Moto Shoes Black","Puma","42","bla bla"),
            PairOfShoes("City Shoes Red","Channel","38", "bli blou blo bla"),
            PairOfShoes("Air Max Impact 2","Nike","45","blou bla bli bla blo"),
            PairOfShoes("Sneakers Green","Levis","42","blo blo bla bli bla")
        )
    }

    fun observeLiveData() : LiveData<MutableList<PairOfShoes>> {
        return shoesList
    }

    fun addPairOfShoes() {
        _shoesList.value?.add(
            PairOfShoes(shoesName.value.toString(), companyName.value.toString(), shoesSize.value.toString(), description.value.toString())
        )
    }
}