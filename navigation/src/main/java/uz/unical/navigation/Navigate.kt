package uz.unical.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

class Navigate {

    lateinit var navController: NavController
    private val navBuilder = NavOptions.Builder()

    fun navigate(direction: Direction) {
        navBuilder.setPopUpTo(R.id.online_education_nav_graph, true)
        when (direction) {
            Direction.Home -> {
                navController.navigate(
                    OnlineEducationNavGraphDirections.toHome(),
                    navBuilder.build()
                )
            }
            Direction.Profile -> {
                navController.navigate(
                    OnlineEducationNavGraphDirections.toProfile(),
                    navBuilder.build()
                )
            }
            Direction.Search -> {
                navController.navigate(
                    OnlineEducationNavGraphDirections.toSearch(),
                    navBuilder.build()
                )
            }
            Direction.Saved -> {
                navController.navigate(
                    OnlineEducationNavGraphDirections.toSaved(),
                    navBuilder.build()
                )
            }
        }
    }
}