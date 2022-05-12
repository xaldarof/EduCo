package uz.unical.home.ui.adapter.fake

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.unical.core.databinding.CommentItemBinding
import uz.unical.core.databinding.ImageItemBinding
import uz.unical.core.databinding.LessonItemBinding
import uz.unical.core.databinding.ReccomendedCourseItemBinding

/**
 * Created by Temur on 10/05/22.
 */

class TestChildAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Vh(
            ReccomendedCourseItemBinding.inflate(
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

    private inner class Vh(private val binding: ReccomendedCourseItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}


class TestLessonAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Vh(
            LessonItemBinding.inflate(
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

    private inner class Vh(private val binding: LessonItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}

class TestImageAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Vh(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Vh)
    }

    override fun getItemCount(): Int = 3

    private inner class Vh(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}


class TestCommentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Vh(
            CommentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Vh)
    }

    override fun getItemCount(): Int = 3

    private inner class Vh(private val binding: CommentItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}

