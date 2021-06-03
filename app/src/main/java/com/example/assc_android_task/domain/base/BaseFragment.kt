package com.example.assc_android_task.domain.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

abstract class BaseFragment : Fragment() {

  abstract fun layoutId(): Int
  abstract fun viewLifeCycleOwner(): LifecycleOwner
  lateinit var binding: ViewDataBinding
  lateinit var dialog: android.app.AlertDialog

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = binding(container!!)
    binding.lifecycleOwner = viewLifecycleOwner
    return binding.root
  }

  open fun onBackPressed() {}

  fun closeFragment() {
    requireActivity().onBackPressed()
  }
}

