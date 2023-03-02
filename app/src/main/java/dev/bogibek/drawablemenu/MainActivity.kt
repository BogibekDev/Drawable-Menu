package dev.bogibek.drawablemenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import dev.bogibek.drawablemenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupDrMenu()
    }

    private fun setupDrMenu() {
        binding.apply {
            ivMenu.setOnClickListener {
                drawerLayout.openDrawer(GravityCompat.START)
            }
            navigationView.itemIconTintList = null
            val navController =
                (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController
            NavigationUI.setupWithNavController(navigationView, navController)

        }
    }
}