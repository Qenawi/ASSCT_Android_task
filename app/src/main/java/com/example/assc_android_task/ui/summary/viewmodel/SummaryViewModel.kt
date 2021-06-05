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

class SummaryViewModel @Inject constructor(
  app: Application,
  val useCase: SummaryUseCase
) : BaseViewModel<SummaryUseCase>(app, useCase) {
  var data = ArrayList<AdapterItem>()
  var adapter = SummaryAdapter()
  var dataSrc = ArrayList<String>()
  var view: SummaryViewProtocol? = null
  fun pullSummary() {
    obsShowProgressBar.set(true)
    useCase.getRecipeInfo(dataSrc) { result ->
      obsShowProgressBar.set(false)
      result.either(::onRecipeResultFail, ::onRecipeResult)

    }
  }

  fun closeAppliction() {
    view?.closeApplication()
  }

  fun newRecipe() {
    view?.openNewRecipe()
  }
}

//MARK:- Recipe Result
private fun SummaryViewModel.onRecipeResult(result: SummaryRequestModel) {
  data.clear()

  data.add(AdapterItem(result.calories.toString(), "", "Calories"))
  data.add(
    AdapterItem(
      "${result.totalNutrients?.fAT?.quantity}${result.totalNutrients?.fAT?.unit}",
      "${result.totalDaily?.fAT?.quantity}${result.totalDaily?.fAT?.unit}", "Fat"
    )
  )
  data.add(
    AdapterItem(
      "${result.totalNutrients?.cHOLE?.quantity}${result.totalNutrients?.fAT?.unit}",
      "${result.totalDaily?.fAT?.quantity}${result.totalDaily?.cHOLE?.unit}", "Cholesterol"
    )
  )

  data.add(
    AdapterItem(
      "${result.totalNutrients?.nA?.quantity}${result.totalNutrients?.nA?.unit}",
      "${result.totalDaily?.fAT?.quantity}${result.totalDaily?.fAT?.unit}", "Sodium"
    )
  )

  data.add(
    AdapterItem(
      "${result.totalNutrients?.cHOCDF?.quantity}${result.totalNutrients?.cHOCDF?.unit}",
      "${result.totalDaily?.fAT?.quantity}${result.totalDaily?.fAT?.unit}", "Carbohydrate"
    )
  )
  data.add(
    AdapterItem(
      "${result.totalNutrients?.pROCNT?.quantity}${result.totalNutrients?.pROCNT?.unit}",
      "${result.totalDaily?.fAT?.quantity}${result.totalDaily?.fAT?.unit}", "Protein"
    )
  )

  data.add(
    AdapterItem(
      "${result.totalNutrients?.vITARAE?.quantity}${result.totalNutrients?.pROCNT?.unit}",
      "${result.totalDaily?.fAT?.quantity}${result.totalDaily?.vITARAE?.unit}", "Vitamin"
    )
  )

  data.add(
    AdapterItem(
      "${result.totalNutrients?.cA?.quantity}${result.totalNutrients?.cA?.unit}",
      "${result.totalDaily?.cA?.quantity}${result.totalDaily?.cA?.unit}", "Calcium"
    )
  )

  data.add(
    AdapterItem(
      "${result.totalNutrients?.fE?.quantity}${result.totalNutrients?.fE?.unit}",
      "${result.totalDaily?.fE?.quantity}${result.totalDaily?.fE?.unit}", "iron"
    )
  )

  data.add(
    AdapterItem(
      "${result.totalNutrients?.k?.quantity}${result.totalNutrients?.k?.unit}",
      "${result.totalDaily?.k?.quantity}${result.totalDaily?.k?.unit}", "Potassium"
    )
  )
  adapter.setList(data)
}

private fun SummaryViewModel.onRecipeResultFail(result: Failure) {
  setError(result.f_causeSt)
}