package uz.unical.search.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.unical.core.databinding.SearchItemBinding
import uz.unical.core.databinding.TopSearchItemBinding

/**
 * Created by Temur on 10/05/22.
 */

class SearchTestAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Vh(
            SearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Vh)
    }

    override fun getItemCount(): Int = 15

    private inner class Vh(private val binding: SearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}

