package uz.unical.core.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import uz.unical.core.tools.setCurrentScreen


/**
 * Created by Temur on 15/03/22.
 */

abstract class BaseFragment : Fragment {

    lateinit var ctx: Context
    lateinit var act: Activity

    constructor() : super()
    constructor(contentLayoutId: Int) : super(contentLayoutId)

    open fun setUpClicks() {

    }

    open fun observe() {

    }

    open fun before() {

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
        act = requireActivity()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        before()
        setUpClicks()

        lifecycleScope.launch {
            launch {
                observe()
            }
            launch {
                collectFlow()
            }
        }
    }

    open suspend fun collectFlow() {}

    fun navigate(
        direction: NavDirections,
        navExtras: Navigator.Extras? = null,
        @IdRes selectedMenuId: Int? = null
    ) {
        with(findNavController()) {
            currentDestination?.getAction(direction.actionId)?.let {
                if (navExtras == null)
                    navigate(direction)
                else
                    navigate(direction, navExtras)
            }
        }
        selectedMenuId?.let {
            setCurrentScreen.setCurrentScreen(selectedMenuId)
        }
    }

    fun color(color: Int) = ContextCompat.getColor(ctx, color)

    protected fun onBackPressed(onBack: () -> Boolean) {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner) {
                if (!onBack()) activity?.finish()
            }
    }

    open val title = 0

    protected fun navigateToBack() {
        findNavController().popBackStack()
    }
}