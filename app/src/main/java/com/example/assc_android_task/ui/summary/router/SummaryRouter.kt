package com.example.assc_android_task.ui.summary.router

import androidx.navigation.fragment.findNavController
import com.example.assc_android_task.ui.summary.layout.FragmentSummary
import com.example.assc_android_task.ui.summary.layout.FragmentSummaryDirections
//MARK:- Summary Router
object SummaryRouter {
  //MARK- close application
  fun close(summaryFragment: FragmentSummary) {
    summaryFragment.activity?.finish()
  }

  ///MARK:- start new recipe
  fun newRecipe(summaryFragment: FragmentSummary) {
    summaryFragment.findNavController()
      .navigate(FragmentSummaryDirections.actionFragmentSummaryToFragmentInput())
  }
}