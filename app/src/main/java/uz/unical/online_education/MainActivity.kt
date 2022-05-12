package uz.unical.online_education

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import uz.unical.navigation.Direction
import uz.unical.navigation.Navigate
import uz.unical.navigation.Navigator
import uz.unical.online_education.databinding.ActivityMainBinding
import uz.unical.search.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding
    private var currentScreenId = uz.unical.core.R.id.home
    private val navigator = Navigate()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val navHostFragment =
            supportFragmentManager.findFragmentById(uz.unical.online_education.R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        navigator.navController = navController

        val coreDestinations = listOf(
            R.id.searchFragment,
            uz.unical.home.R.id.homeFragment,
            uz.unical.saved.R.id.savedFragment,
            uz.unical.profile.R.id.profileFragment
        )

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id in coreDestinations) {
                showFooter()
            } else {
                hideFooter()
            }
        }

        binding.bottomNav.setOnItemSelectedListener {
            if (it.itemId != currentScreenId) {
                when (it.itemId) {



                    uz.unical.core.R.id.home -> {
                        navigate(Direction.Home)
                    }
                    uz.unical.core.R.id.profile -> {
                        navigate(Direction.Profile)
                    }

                    uz.unical.core.R.id.search -> {
                        navigate(Direction.Search)
                    }
                    uz.unical.core.R.id.saved -> {
                        navigate(Direction.Saved)
                    }
                }
                currentScreenId = it.itemId
            }
            return@setOnItemSelectedListener true
        }

        val iconsColorStates = ColorStateList(
            arrayOf(
                intArrayOf(-android.R.attr.state_checked),
                intArrayOf(android.R.attr.state_checked)
            ), intArrayOf(
                Color.parseColor("#282F3E"),
                Color.parseColor("#FF3700B3")
            )
        )

        val textColorStates = ColorStateList(
            arrayOf(
                intArrayOf(-android.R.attr.state_checked),
                intArrayOf(android.R.attr.state_checked)
            ), intArrayOf(
                Color.parseColor("#282F3E"),
                Color.parseColor("#FF3700B3")
            )
        )

        binding.bottomNav.itemIconTintList = iconsColorStates
        binding.bottomNav.itemTextColor = textColorStates

    }

    private fun hideFooter() {
        binding.bottomNav.animate().translationY(500f).setDuration(150).start()
    }

    private fun showFooter() {
        binding.bottomNav.animate().translationY(0f).setDuration(150).start()
    }

    override fun navigate(direction: Direction, args: Any?, toRight: Boolean?) {
        navigator.navigate(direction)
    }
}