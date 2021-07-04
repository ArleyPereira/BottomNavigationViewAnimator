package com.br.bottomnavigationview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentItem = R.id.home

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setSupportActionBar(toolbar)

        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        // para toolbar
        //setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            crossfade(destination.id)
        }

        imageButton.setOnClickListener {
            navController.navigate(R.id.pagamentoFragment)
        }

    }

    private fun crossfade(destination: Int){

        if(destination != R.id.home && destination != R.id.feed
            && destination != R.id.cartao && destination != R.id.ajuda){

            nav_host_fragment.apply {
                alpha = 0f
                animate()
                    .alpha(1f)
                    .setDuration(250)
                    .setListener(null)

                contentView.animate()
                    .alpha(0f)
                    .setDuration(250)
                    .setListener(null)
            }

        }else if(currentItem != destination){

            nav_host_fragment.apply {
                alpha = 0f
                nav_host_fragment.animate()
                    .alpha(1f)
                    .setDuration(1000)
                    .setListener(null)
                currentItem = destination
            }

        } else {

            nav_host_fragment.apply {
                alpha = 0f
                nav_host_fragment.animate()
                    .alpha(1f)
                    .setDuration(250)
                    .setListener(null)

                contentView.animate()
                    .alpha(1f)
                    .setDuration(250)
                    .setListener(null)

            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}