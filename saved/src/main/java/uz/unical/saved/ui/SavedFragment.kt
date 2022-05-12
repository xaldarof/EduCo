package uz.unical.saved.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import uz.unical.core.base.BaseFragment
import uz.unical.saved.databinding.SavedFragmentLayoutBinding
import uz.unical.saved.ui.adapter.fake.TestAdapter

/**
 * Created by Temur on 11/05/22.
 */

@AndroidEntryPoint
class SavedFragment : BaseFragment() {

    private lateinit var binding: SavedFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SavedFragmentLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = TestAdapter()
    }
}