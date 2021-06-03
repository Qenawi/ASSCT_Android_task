package com.example.assc_android_task.ui.summary.layout

import android.view.View
import com.example.assc_android_task.domain.dagger.application.ASSCTApplication

fun FragmentSummary.injectHere() {
  ASSCTApplication.appComponent.inject(this)
}

fun FragmentSummary.setupBinding(): View {
  return binding.root
}

fun FragmentSummary.setupViewModel() {
}