package com.example.assc_android_task.ui.input.router

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.assc_android_task.ui.input.layout.FragmentInputDirections

object FragmentInputRouter {
 //MARK:- open Ingredient fragment
  fun openIngredientList(
    fragment: Fragment,
    data: ArrayList<String>
  ) {
    val action = FragmentInputDirections.actionFragmentInputToFragmentIngredient()
      .setReadList(data.map { a -> a }.toTypedArray())
    fragment.findNavController().navigate(action)
  }
}