package com.example.assc_android_task.ui.summary.viewmodel

import android.app.Application
import com.example.assc_android_task.domain.base.BaseViewModel
import com.example.assc_android_task.domain.network.Failure
import com.example.assc_android_task.ui.summary.layout.SummaryAdapter
import com.example.assc_android_task.ui.summary.model.AdapterItem
import com.example.assc_android_task.ui.summary.model.SummaryRequestModel
import com.example.assc_android_task.ui.summary.protocol.SummaryViewProtocol
import com.example.assc_android_task.ui.summary.repo.SummaryUseCase
import javaslang.control.Either
import javax.inject.Inject

//MARK:- SummaryViewModel @Docs
class SummaryViewModel @Inject constructor(
  app: Application,
  val useCase: SummaryUseCase
) : BaseViewModel<SummaryUseCase>(app, useCase) {
  var data = ArrayList<AdapterItem>()
  var adapter = SummaryAdapter()
  var dataSrc = ArrayList<String>()
  var view: SummaryViewProtocol? = null

  //MARK:-  pull recipe summary from network
  fun pullSummary() {
    showProgress()
    useCase.getRecipeInfo(dataSrc) { result ->
      result.either(::onRecipeResultFail, ::onRecipeResult)
    }
  }

  //MARK:- on close application selection
  fun closeApplication() {
    view?.closeApplication()
  }

  //MARK:- on new recipe selection
  fun newRecipe() {
    view?.openNewRecipe()
  }
}

//MARK:- Recipe Result
private fun SummaryViewModel.onRecipeResult(result: SummaryRequestModel) {
  data.clear()
  data.addAll(useCase.convertToAdapterArray(result))
  adapter.setList(data)
  closeProgress()
}

private fun SummaryViewModel.onRecipeResultFail(result: Failure) {
  setError(result.f_causeSt)
}