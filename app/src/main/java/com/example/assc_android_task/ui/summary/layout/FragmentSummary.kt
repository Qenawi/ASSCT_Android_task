package com.example.assc_android_task.ui.summary.layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.assc_android_task.R
import com.example.assc_android_task.domain.base.BaseFragment
import com.example.assc_android_task.ui.summary.protocol.SummaryViewProtocol
import com.example.assc_android_task.ui.summary.router.SummaryRouter
import javax.inject.Inject

class FragmentSummary : BaseFragment(), SummaryViewProtocol {
  override fun layoutId() = R.layout.fragment_summary
  override fun viewLifeCycleOwner() = viewLifecycleOwner

  @Inject
  lateinit var factory: ViewModelProvider.Factory
  lateinit var viewModel: SummaryViewModel
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

  //MARK:- view navigation callBack
  override fun openNewRecipe() {
    SummaryRouter.newRecipe(this)
  }

  override fun closeApplication() {
    SummaryRouter.close(this)
  }
}