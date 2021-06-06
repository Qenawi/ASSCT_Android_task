package com.example.assc_android_task.ui.input.layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.assc_android_task.R
import com.example.assc_android_task.domain.base.BaseFragment
import com.example.assc_android_task.ui.input.protocol.InputViewProtocol
import com.example.assc_android_task.ui.input.router.FragmentInputRouter
import com.example.assc_android_task.ui.input.viewmodel.InputViewModel
import kotlinx.android.synthetic.main.fragment_input.button
import javax.inject.Inject

//MARK:- FragmentInput @Docs
class FragmentInput : BaseFragment(), InputViewProtocol {
  override fun layoutId() = R.layout.fragment_input
  override fun viewLifeCycleOwner() = viewLifecycleOwner

  @Inject
  lateinit var factory: ViewModelProvider.Factory
  lateinit var viewModel: InputViewModel
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

  override fun openIngredient(data: ArrayList<String>) {
    FragmentInputRouter.openIngredientList(fragment = this, data = data)
  }
}