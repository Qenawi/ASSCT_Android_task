package com.example.assc_android_task.ui.input.router

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.assc_android_task.R
import com.example.assc_android_task.ui.gredient.layout.FragmentGradientArgs
import com.example.assc_android_task.ui.gredient.layout.FragmentGradientDirections.ActionFragmentGradientToFragmentSummary
import com.example.assc_android_task.ui.input.layout.FragmentInput
import com.example.assc_android_task.ui.input.layout.FragmentInputDirections
import com.example.assc_android_task.ui.input.layout.FragmentInputDirections.ActionFragmentInputToFragmentGradient
import com.google.android.material.navigation.NavigationView

object FragmentInputRouter {
  val FragmentInputToFragmentGradientListKey = "mListKey"

  fun openGradientList(
    fragment: Fragment,
    data: ArrayList<String>
  ) {
    val action = FragmentInputDirections.actionFragmentInputToFragmentGradient()
      .setReadList(data.map { a -> a }.toTypedArray())
    fragment.findNavController().navigate(action)
  }
}