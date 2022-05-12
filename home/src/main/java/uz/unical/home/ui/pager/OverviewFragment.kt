package uz.unical.home.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.unical.core.base.BaseFragment
import uz.unical.home.databinding.OverviewFragmentLayoutBinding
import uz.unical.home.ui.CourseDetailFragmentDirections
import uz.unical.home.ui.adapter.fake.TestCommentAdapter
import uz.unical.home.ui.adapter.fake.TestImageAdapter

/**
 * Created by Temur on 11/05/22.
 */

@AndroidEntryPoint
class OverviewFragment : BaseFragment() {

    private lateinit var binding:OverviewFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OverviewFragmentLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvProjectByStudent.adapter = TestImageAdapter()
        binding.rvComment.adapter = TestCommentAdapter()
        binding.rvComments.adapter = TestCommentAdapter()

        binding.seeMoreBtn.setOnClickListener {
            binding.intoductionTv.maxLines = Int.MAX_VALUE
        }

        binding.loadMoreCommentBtn.setOnClickListener {
            navigate(CourseDetailFragmentDirections.actionCourseDetailFragmentToCommentsFragment())
        }
    }
}