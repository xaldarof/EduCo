package uz.unical.home.ui.adapter.fake

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.unical.core.databinding.CategoryItemBinding
import uz.unical.core.databinding.ReccomendedCourseItemBinding

/**
 * Created by Temur on 10/05/22.
 */

class TestAdapter(private val action: () -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val adapter = TestChildAdapter()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Vh(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), action
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Vh).onBind()
    }

    override fun getItemCount(): Int = 15

    private inner class Vh(
        private val binding: CategoryItemBinding,
        private val action: () -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
            binding.rv.adapter = adapter
            binding.root.setOnClickListener {
                action.invoke()
            }
        }
    }
}

