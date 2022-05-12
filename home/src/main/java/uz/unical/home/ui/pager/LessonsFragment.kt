package uz.unical.home.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import uz.unical.core.base.BaseFragment
import uz.unical.home.databinding.LessonsFragmentLayoutBinding
import uz.unical.home.ui.adapter.fake.TestLessonAdapter

/**
 * Created by Temur on 11/05/22.
 */

@AndroidEntryPoint
class LessonsFragment : BaseFragment() {

    private lateinit var binding:LessonsFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LessonsFragmentLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = TestLessonAdapter()
    }
}