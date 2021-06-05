package com.example.assc_android_task.ui.summary.layout

import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.assc_android_task.databinding.FragmentSummaryBinding
import com.example.assc_android_task.domain.base.viewModel
import com.example.assc_android_task.domain.dagger.application.ASSCTApplication
import com.example.assc_android_task.ui.gredient.layout.FragmentGradientArgs

fun FragmentSummary.injectHere() {
  ASSCTApplication.appComponent.inject(this)
}

fun FragmentSummary.setupBinding(): View {
  with(binding as FragmentSummaryBinding){
    this.viewModel  = this@setupBinding.viewModel
  }
  return binding.root
}

fun FragmentSummary.setupViewModel() {
  viewModel = viewModel(factory) {

    val args: FragmentSummaryArgs by navArgs()
    dataSrc = args.readList?.toCollection(ArrayList()) ?: arrayListOf()
    view = this@setupViewModel
    pullSummary()
  }
}