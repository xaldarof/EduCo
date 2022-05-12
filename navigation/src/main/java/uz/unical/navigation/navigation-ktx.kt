package uz.unical.navigation

import androidx.fragment.app.Fragment

val Fragment.navController: Navigator
    get() = activity as Navigator