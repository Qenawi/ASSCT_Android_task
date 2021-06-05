package com.example.assc_android_task.ui.gredient.router

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.assc_android_task.ui.gredient.layout.FragmentGradient
import com.example.assc_android_task.ui.gredient.layout.FragmentGradientDirections
import com.example.assc_android_task.ui.input.layout.FragmentInputDirections

object GradientRouter {
  //MARK:- navigate to summary screen
  fun openSummaryScreen(
    gradientFragment: FragmentGradient,
    data: ArrayList<String>
  ) {
    val action = FragmentGradientDirections.actionFragmentGradientToFragmentSummary()
      .setReadList(data.map { a -> a }.toTypedArray())
    gradientFragment.findNavController().navigate(action)
  }
}