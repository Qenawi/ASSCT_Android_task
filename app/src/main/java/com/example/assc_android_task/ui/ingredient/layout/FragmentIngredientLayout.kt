package com.example.assc_android_task.ui.ingredient.layout

import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.assc_android_task.databinding.FragmentIngredientBinding
import com.example.assc_android_task.domain.base.observe
import com.example.assc_android_task.domain.base.toast
import com.example.assc_android_task.domain.base.viewModel
import com.example.assc_android_task.domain.dagger.application.ASSCTApplication
import com.example.assc_android_task.ui.ingredient.viewmodel.IngredientViewModel

//MARK:- handle injection
fun FragmentIngredient.injectHere() {
  ASSCTApplication.appComponent.inject(this)
}

//MARK:- handle view binding
fun FragmentIngredient.setupBinding(): View {
  with(binding as FragmentIngredientBinding) {
    this.viewModel = this@setupBinding.viewModel
  }
  return binding.root
}

//MARK:- setup view model
fun FragmentIngredient.setupViewModel() {
  viewModel = viewModel(factory) {
    //MARK:- observe for issues
    observe(toastMutable) { msg ->
      msg?.let {
        this@setupViewModel.toast(msg.f_causeSt ?: "")
      }
    }
    //MARK:- read args
    updateArgs(this)
    //MARK:- link view call back
    view = this@setupViewModel
    //MARK:- pull each Ingredient content
    pullData()
  }
}

//MARK:- read navigation args
private fun FragmentIngredient.updateArgs(vm: IngredientViewModel) {
  val args: FragmentIngredientArgs by navArgs()
  vm.data = args.readList?.toCollection(ArrayList()) ?: arrayListOf()
}