package uz.unical.search.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.unical.core.databinding.TopSearchItemBinding

/**
 * Created by Temur on 10/05/22.
 */

class TestAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = arrayListOf("Materials", "Objective", "Directions", "Assessment", "lesson")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Vh(
            TopSearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Vh).onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    private inner class Vh(private val binding: TopSearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(str: String) {
            binding.titleTv.text = str
        }
    }
}

