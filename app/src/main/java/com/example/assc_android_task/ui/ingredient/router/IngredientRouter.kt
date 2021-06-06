package com.example.assc_android_task.ui.ingredient.router

import androidx.navigation.fragment.findNavController
import com.example.assc_android_task.ui.ingredient.layout.FragmentIngredient
import com.example.assc_android_task.ui.ingredient.layout.FragmentIngredientDirections

object IngredientRouter {
  //MARK:- navigate to summary screen
  fun openSummaryScreen(
    ingredientFragment: FragmentIngredient,
    data: ArrayList<String>
  ) {

    ingredientFragment.findNavController()
    val action = FragmentIngredientDirections.actionFragmentIngredientToFragmentSummary()
      .setReadList(data.map { a -> a }.toTypedArray())
    ingredientFragment.findNavController().navigate(action)
  }
}