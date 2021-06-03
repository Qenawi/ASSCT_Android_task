package com.example.assc_android_task.ui.gredient.layout

import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.assc_android_task.databinding.FragmentGradientBinding
import com.example.assc_android_task.domain.base.viewModel
import com.example.assc_android_task.domain.dagger.application.ASSCTApplication

fun FragmentGradient.injectHere() {
  ASSCTApplication.appComponent.inject(this)
}

fun FragmentGradient.setupBinding(): View {
  with(binding as FragmentGradientBinding) {
    this.viewModel = this@setupBinding.viewModel
  }
  return binding.root
}

fun FragmentGradient.setupViewModel() {
  viewModel = viewModel(factory) {
    //MARK:- read args
    val args: FragmentGradientArgs by navArgs()
    data = args.readList?.toCollection(ArrayList()) ?: arrayListOf()
    //MARK:- pull each gradient content
    pullData()
  }
}