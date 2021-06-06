package com.example.assc_android_task.ui.input.layout

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.databinding.BindingAdapter
import com.example.assc_android_task.databinding.FragmentInputBinding
import com.example.assc_android_task.domain.base.viewModel
import com.example.assc_android_task.domain.dagger.application.ASSCTApplication

//MARK:- handle injection
fun FragmentInput.injectHere() {
  ASSCTApplication.appComponent.inject(this)
}

//MARK:- handle view binding
fun FragmentInput.setupBinding(): View {
  with(binding as FragmentInputBinding)
  {
    this.viewModel = this@setupBinding.viewModel
  }
  return binding.root
}
//MARK:- setup view model

fun FragmentInput.setupViewModel() {
  viewModel = viewModel(factory) {
    this.view = this@setupViewModel
  }
}

//MARK:- Button Extension
@BindingAdapter("handle_input")
fun Button.mangeBasedOnInput(data: String?) {
  this.isEnabled = !data.isNullOrEmpty()
}