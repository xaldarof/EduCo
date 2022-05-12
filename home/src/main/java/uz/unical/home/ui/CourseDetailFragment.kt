package uz.unical.home.ui

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.unical.core.R
import uz.unical.core.base.BaseFragment
import uz.unical.home.databinding.CourseFragmentLayoutBinding
import uz.unical.home.ui.adapter.PagerAdapter
import uz.unical.home.ui.pager.LessonsFragment
import uz.unical.home.ui.pager.OverviewFragment

/**
 * Created by Temur on 11/05/22.
 */

@AndroidEntryPoint
class CourseDetailFragment : BaseFragment() {

    private lateinit var binding: CourseFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CourseFragmentLayoutBinding.inflate(inflater)
        binding.linearContainer.layoutTransition = LayoutTransition()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pages = listOf<Pair<Fragment, String>>(
            Pair(OverviewFragment(), getString(R.string.overview)),
            Pair(LessonsFragment(), getString(R.string.lessons)),
        )

        binding.pager.adapter = PagerAdapter(
            childFragmentManager, requireActivity().lifecycle, pages.map { it.first },
        )

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = pages[position].second
        }.attach()

    }
}