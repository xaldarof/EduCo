package uz.unical.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.unical.core.R
import uz.unical.core.base.BaseFragment
import uz.unical.core.utils.onStateChanged
import uz.unical.profile.databinding.ProfileFragmentLayoutBinding
import uz.unical.profile.ui.pager.CoursesFragment
import uz.unical.profile.ui.pager.FollowingFragment
import uz.unical.profile.ui.pager.ProjectsFragment
import uz.unical.profile.ui.pager.adapter.PagerAdapter
import kotlin.math.abs


/**
 * Created by Temur on 10/05/22.
 */

@AndroidEntryPoint
class ProfileFragment : BaseFragment() {

    private lateinit var binding: ProfileFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pages = listOf<Pair<Fragment, String>>(
            Pair(ProjectsFragment(), getString(R.string.projects)),
            Pair(CoursesFragment(), getString(R.string.courses)),
            Pair(FollowingFragment(), getString(R.string.following))
        )

        binding.pager.adapter = PagerAdapter(
            childFragmentManager, requireActivity().lifecycle, pages.map { it.first },
        )

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = pages[position].second
        }.attach()

        binding.appBarLayout.onStateChanged(
            onCollapse = {
                requireActivity().window.statusBarColor = ContextCompat.getColor(ctx, R.color.white)

            }, onExpanded = {
                requireActivity().window.statusBarColor = ContextCompat.getColor(ctx, R.color.red)
            })
    }

    override fun onResume() {
        super.onResume()
        requireActivity().window.statusBarColor = ContextCompat.getColor(ctx, R.color.red)
    }

    override fun onStop() {
        super.onStop()
        requireActivity().window.statusBarColor = ContextCompat.getColor(ctx, R.color.white)
    }
}