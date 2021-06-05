package com.example.assc_android_task.ui.gredient.viewmodel

import android.app.Application
import com.example.assc_android_task.domain.base.BaseViewModel
import com.example.assc_android_task.domain.network.Either
import com.example.assc_android_task.domain.network.Failure
import com.example.assc_android_task.domain.network.toResultOrNull
import com.example.assc_android_task.ui.gredient.layout.RecyclerViewAdapter
import com.example.assc_android_task.ui.gredient.model.AdapterItem
import com.example.assc_android_task.ui.gredient.protocol.GradientViewProtocol
import com.example.assc_android_task.ui.gredient.repo.GradientUseCase
import javax.inject.Inject

class GradientViewModel @Inject constructor(
  app: Application,
  private val useCase: GradientUseCase
) : BaseViewModel<GradientUseCase>(app, useCase) {
  val adapter = RecyclerViewAdapter()
  var data = ArrayList<String>()
  var result = ArrayList<AdapterItem>()

  //MARK:- gradient view
  var view: GradientViewProtocol? = null

  //MARK:- pull data for List
  fun pullData() {
    obsShowProgressBar.set(true)
    useCase.pullData(data, ::onResult)
  }

  //MARK:- on button click
  fun OpenSummary() {
    view?.openSummaryFragment(data)
  }
}

//MARK:- onResult Success
private fun GradientViewModel.onResult(data: List<Either<Failure, AdapterItem>>) {
  result.clear()
  data.forEach { item -> item.toResultOrNull { res -> res?.let { aa -> result.add(aa) } } }

  obsShowProgressBar.set(false)
  adapter.setList(result)
}

