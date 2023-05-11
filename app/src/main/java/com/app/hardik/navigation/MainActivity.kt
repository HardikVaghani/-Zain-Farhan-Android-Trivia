package com.app.hardik.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.app.hardik.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        drawerLayout = binding.drawerLayout

        val navaController = this.findNavController(R.id.myNavHostFragment)
//        NavigationUI.setupActionBarWithNavController(this, navaController)
        NavigationUI.setupActionBarWithNavController(this, navaController, drawerLayout)

        appBarConfiguration = AppBarConfiguration(navaController.graph, drawerLayout)

        navaController.addOnDestinationChangedListener{nc:NavController, nd:NavDestination, bundle:Bundle?
            ->
            if (nd.id == nc.graph.startDestinationId){
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }else{
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }

        NavigationUI.setupWithNavController(binding.navView, navaController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
//        return navController.navigateUp() //home par avata back arrow hide thashe ne baki jagya ye show thashe
        return NavigationUI.navigateUp(navController,appBarConfiguration) // home par avata back arrow ni jagya ye hamburger icon avshe ane bije abadhe back arrow
    }
}

//https://github.com/Zain-de94/Navigation
//navigation (Zain Farhan) video 37

//https://github.com/Zain-de94/Navigation/tree/Android-trivia-Step-3-Conditional-Navigation