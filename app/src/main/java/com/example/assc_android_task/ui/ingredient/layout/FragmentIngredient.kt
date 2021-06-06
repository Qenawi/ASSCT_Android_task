package com.example.assc_android_task.ui.ingredient.layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.assc_android_task.R
import com.example.assc_android_task.domain.base.BaseFragment
import com.example.assc_android_task.ui.ingredient.protocol.IngredientViewProtocol
import com.example.assc_android_task.ui.ingredient.router.IngredientRouter
import com.example.assc_android_task.ui.ingredient.viewmodel.IngredientViewModel
import javax.inject.Inject
//MARK:- FragmentIngredient @Docs
class FragmentIngredient : BaseFragment(), IngredientViewProtocol {
  override fun layoutId() = R.layout.fragment_ingredient
  override fun viewLifeCycleOwner() = viewLifecycleOwner

  @Inject
  lateinit var factory: ViewModelProvider.Factory
  lateinit var viewModel: IngredientViewModel
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    injectHere()
    setupViewModel()
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    return setupBinding()
  }

  //MARK:-
  override fun openSummaryFragment(recipe: ArrayList<String>)
  {
    IngredientRouter.openSummaryScreen(this, recipe)
  }
}