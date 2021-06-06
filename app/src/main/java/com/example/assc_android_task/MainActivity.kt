package com.example.assc_android_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import com.example.assc_android_task.domain.dagger.application.ASSCTApplication

class MainActivity : AppCompatActivity() {
  //MARK:- main navigation controller
  private var navController: NavController? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setupNavigation()
  }

  //MARK: update view title based on lapel
  private fun setupNavigation() {
    navController = (supportFragmentManager.findFragmentById(
      R.id.nav_host_fragment
    ) as NavHostFragment).navController
    navController?.addOnDestinationChangedListener { controller, destination, arguments ->
      supportActionBar?.subtitle = destination.label
    }
  }
}