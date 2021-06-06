package com.example.assc_android_task.domain.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

//MARK:- BaseFragment @Docs
abstract class BaseFragment : Fragment() {

  abstract fun layoutId(): Int
  abstract fun viewLifeCycleOwner(): LifecycleOwner
  lateinit var binding: ViewDataBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = binding(container!!)
    binding.lifecycleOwner = viewLifecycleOwner
    return binding.root
  }

  fun closeFragment() {
    requireActivity().onBackPressed()
  }
}

//MARK:- Toast Extension
fun Fragment?.toast(st: String?) =
  this?.context?.let { ctx ->
    Toast.makeText(ctx, st, Toast.LENGTH_SHORT).show()
  }


