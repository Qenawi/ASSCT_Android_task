package com.example.assc_android_task.ui.gredient.layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.assc_android_task.R
import com.example.assc_android_task.domain.base.BaseFragment
import com.example.assc_android_task.ui.gredient.viewmodel.GradientViewModel
import javax.inject.Inject

class FragmentGradient : BaseFragment() {
  override fun layoutId() = R.layout.fragment_gradient
  override fun viewLifeCycleOwner() = viewLifecycleOwner

  @Inject
  lateinit var factory: ViewModelProvider.Factory
  lateinit var viewModel:GradientViewModel
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    injectHere()
    setupViewModel()
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View?
  {
    super.onCreateView(inflater, container, savedInstanceState)
    return setupBinding()
  }
}