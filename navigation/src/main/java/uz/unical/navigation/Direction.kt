package uz.unical.navigation

sealed class Direction {
    object Home : Direction()
    object Profile : Direction()
    object Search : Direction()
    object Saved : Direction()

}
