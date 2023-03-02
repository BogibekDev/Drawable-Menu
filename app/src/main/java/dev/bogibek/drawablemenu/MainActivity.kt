package dev.bogibek.drawablemenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import dev.bogibek.drawablemenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupDrMenu()
    }

    private fun setupDrMenu() {
        binding.apply {
            ivMenu.setOnClickListener {
                drawerLayout.openDrawer(GravityCompat.START)
            }
            navigationView.itemIconTintList=null
            val navController=Navigation.findNavController(this@MainActivity,R.id.navHostFragment)
            NavigationUI.setupWithNavController(navigationView,navController)
            navController.addOnDestinationChangedListener { controller, destination, arguments ->
                tvName.text = destination.label
            }
        }
    }
}