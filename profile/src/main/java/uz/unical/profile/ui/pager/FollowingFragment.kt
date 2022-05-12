package uz.unical.profile.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.unical.core.base.BaseFragment
import uz.unical.profile.databinding.FollowingFragmentLayoutBinding
import uz.unical.profile.ui.adapter.TestAdapter

/**
 * Created by Temur on 11/05/22.
 */

class FollowingFragment : BaseFragment() {

    private lateinit var binding:FollowingFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FollowingFragmentLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = TestAdapter()

    }
}