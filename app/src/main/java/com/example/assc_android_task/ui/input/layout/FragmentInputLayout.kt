package com.example.assc_android_task.ui.input.layout

import android.view.View
import android.widget.Button
import androidx.databinding.BindingAdapter
import com.example.assc_android_task.databinding.FragmentInputBinding
import com.example.assc_android_task.domain.base.viewModel
import com.example.assc_android_task.domain.dagger.application.ASSCTApplication
import org.jetbrains.kotlin.backend.wasm.ir2wasm.bind

fun FragmentInput.injectHere() {
  ASSCTApplication.appComponent.inject(this)
}

fun FragmentInput.setupBinding(): View {
  with(binding as FragmentInputBinding)
  {
    this.viewModel = this@setupBinding.viewModel
  }
  return binding.root
}

fun FragmentInput.setupViewModel() {
  viewModel = viewModel(factory) {
    this.view = this@setupViewModel
  }
}

//MARK:- Button Extension
@BindingAdapter("handle_input")
fun Button.mangeBasedOnInput(data: String?)
{
  this.isEnabled = !data.isNullOrEmpty()
}