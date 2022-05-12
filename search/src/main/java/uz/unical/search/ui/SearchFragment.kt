package uz.unical.search.ui

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager
import com.beloo.widget.chipslayoutmanager.layouter.breaker.IRowBreaker
import dagger.hilt.android.AndroidEntryPoint
import uz.unical.core.base.BaseFragment
import uz.unical.search.databinding.SearchFragmentLayoutBinding
import uz.unical.search.ui.adapter.SearchTestAdapter
import uz.unical.search.ui.adapter.TestAdapter


/**
 * Created by Temur on 10/05/22.
 */

@AndroidEntryPoint
class SearchFragment : BaseFragment() {

    private lateinit var binding: SearchFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chipsLayoutManager =
            ChipsLayoutManager.newBuilder(ctx)
                .setChildGravity(Gravity.LEFT)
                .setScrollingEnabled(false)
                .setMaxViewsInRow(5)
                .setOrientation(ChipsLayoutManager.HORIZONTAL)
                .build()


        binding.rv.layoutManager = chipsLayoutManager
        binding.rv.adapter = TestAdapter()

        binding.rvSearchResult.adapter = SearchTestAdapter()
    }
}