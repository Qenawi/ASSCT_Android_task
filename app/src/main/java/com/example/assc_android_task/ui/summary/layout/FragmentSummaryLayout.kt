package com.example.assc_android_task.ui.summary.layout

import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.assc_android_task.databinding.FragmentSummaryBinding
import com.example.assc_android_task.domain.base.observe
import com.example.assc_android_task.domain.base.toast
import com.example.assc_android_task.domain.base.viewModel
import com.example.assc_android_task.domain.dagger.application.ASSCTApplication
import com.example.assc_android_task.ui.ingredient.layout.FragmentIngredient
import com.example.assc_android_task.ui.ingredient.layout.FragmentIngredientArgs
import com.example.assc_android_task.ui.ingredient.viewmodel.IngredientViewModel
import com.example.assc_android_task.ui.summary.viewmodel.SummaryViewModel

//MARK:- handle injection
fun FragmentSummary.injectHere() {
  ASSCTApplication.appComponent.inject(this)
}

//MARK:- handle view binding
fun FragmentSummary.setupBinding(): View {
  with(binding as FragmentSummaryBinding) {
    this.viewModel = this@setupBinding.viewModel
  }
  return binding.root
}

//MARK:- setup view model
fun FragmentSummary.setupViewModel() {
  viewModel = viewModel(factory) {
    observe(toastMutable) { msg ->
      msg?.let { toast(msg.f_causeSt ?: "") }
    }
    //MARK:- read Args
    updateArgs(this)
    //MARK:- setup view
    view = this@setupViewModel
    //MARK:- pull recipe from network
    pullSummary()
  }
}

//MARK:- read navigation args
private fun FragmentSummary.updateArgs(vm: SummaryViewModel) {
  val args: FragmentSummaryArgs by navArgs()
  vm.dataSrc = args.readList?.toCollection(ArrayList()) ?: arrayListOf()
}