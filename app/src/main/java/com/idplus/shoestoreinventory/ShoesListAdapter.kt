package com.idplus.shoestoreinventory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idplus.shoestoreinventory.databinding.ShoeItemRowBinding
import com.idplus.shoestoreinventory.model.PairOfShoes


class ShoesListAdapter: RecyclerView.Adapter<ShoesListAdapter.ViewHolder>() {

    private var listShoes: List<PairOfShoes> = emptyList()

    inner class ViewHolder(val binding: ShoeItemRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    fun setShoesData(listOfShoes: MutableList<PairOfShoes>) {
        listShoes = listOfShoes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ShoeItemRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.shoes = listShoes[position]
    }

    override fun getItemCount(): Int = listShoes.size
}