package uz.unical.core.tools

import uz.unical.core.base.BaseFragment

interface ScreenController {
    fun setCurrentScreen(screen: Int)
}

val BaseFragment.setCurrentScreen: ScreenController
    get() = (activity as ScreenController)

