package com.example.assc_android_task.ui.summary.repo

import com.example.assc_android_task.domain.base.BaseUseCase
import com.example.assc_android_task.ui.summary.model.AdapterItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

//MARK:- Summary UseCase
class SummaryUseCase @Inject constructor(
  val scope: CoroutineScope,
  val dispatcher: CoroutineDispatcher
) : BaseUseCase(scope, dispatcher) {
  //MARK- pull Recipe info
  fun getRecipeInfo(call: (ArrayList<AdapterItem>) -> Unit = {})
  {
    call(arrayListOf())
  }
}