package uz.unical.home.ui.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import uz.unical.core.base.BaseFragment
import uz.unical.home.databinding.CommentsFramgmentLayoutBinding
import uz.unical.home.ui.adapter.fake.TestCommentAdapter

/**
 * Created by Temur on 12/05/22.
 */

@AndroidEntryPoint
class CommentsFragment : BaseFragment() {

    private lateinit var binding: CommentsFramgmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CommentsFramgmentLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = TestCommentAdapter()
    }

    override fun setUpClicks() {
        super.setUpClicks()

        binding.backBtn.setOnClickListener {
            navigateToBack()
        }
    }
}