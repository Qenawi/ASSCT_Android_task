package com.example.assc_android_task.ui.ingredient.viewmodel

import android.app.Application
import com.example.assc_android_task.domain.base.BaseViewModel
import com.example.assc_android_task.domain.network.Either
import com.example.assc_android_task.domain.network.Failure
import com.example.assc_android_task.domain.network.toResultOrNull
import com.example.assc_android_task.ui.ingredient.layout.IngredientAdapter
import com.example.assc_android_task.ui.ingredient.model.AdapterItem
import com.example.assc_android_task.ui.ingredient.protocol.IngredientViewProtocol
import com.example.assc_android_task.ui.ingredient.repo.IngredientUseCase
import com.example.assc_android_task.ui.ingredient.repo.IngredientUseCase.CustomDiffered
import javax.inject.Inject

//MARL:- IngredientViewModel @Docs
class IngredientViewModel @Inject constructor(
  app: Application,
  private val useCase: IngredientUseCase
) : BaseViewModel<IngredientUseCase>(app, useCase) {
  val adapter = IngredientAdapter()
  var data = ArrayList<String>()
  var result = ArrayList<AdapterItem>()

  //MARK:- Ingredient view
  var view: IngredientViewProtocol? = null

  //MARK:- pull data for List
  fun pullData() {
    showProgress()
    useCase.pullData(data, ::onResult)
  }

  //MARK:- on button click
  fun openSummary() {
    view?.openSummaryFragment(data)
  }
}

//MARK:- onResult Success
private fun IngredientViewModel.onResult(data: List<CustomDiffered>) {
  result.clear()
  data.forEach { item ->
    merge(item) { a ->
      result.add(a)
    }

  }

  obsShowProgressBar.set(false)
  adapter.setList(result)
  closeProgress()
}

private fun IngredientViewModel.merge(
  item: CustomDiffered,
  call: (AdapterItem) -> Unit = {}
) {
  val mergedITem = AdapterItem()
  item.name.toResultOrNull { details ->
    mergedITem.cal = details?.cal
    mergedITem.weight = details?.weight
  }
  item.name2.toResultOrNull { naming ->
    mergedITem.title = naming?.parsed?.getOrNull(0)?.food?.label
    mergedITem.unit = naming?.parsed?.getOrNull(0)?.measure?.label
    mergedITem.count = naming?.parsed?.getOrNull(0)?.quantity?.toString()
  }
  call(mergedITem)
}

