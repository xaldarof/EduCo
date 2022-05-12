package uz.unical.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import uz.unical.core.base.BaseFragment
import uz.unical.home.databinding.HomeFragmentLayoutBinding
import uz.unical.home.ui.adapter.fake.TestAdapter

/**
 * Created by Temur on 10/05/22.
 */

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var binding: HomeFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = TestAdapter {
            navigate(HomeFragmentDirections.actionHomeFragmentToCourseDetailFragment())
        }
    }
}