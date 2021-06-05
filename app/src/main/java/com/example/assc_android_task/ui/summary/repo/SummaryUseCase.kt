package com.example.assc_android_task.ui.summary.repo

import com.example.assc_android_task.domain.base.BaseUseCase
import com.example.assc_android_task.domain.network.Either
import com.example.assc_android_task.domain.network.Failure
import com.example.assc_android_task.ui.summary.model.SummaryRequestModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//MARK:- Summary UseCase
class SummaryUseCase @Inject constructor(
  val scope: CoroutineScope,
  val dispatcher: CoroutineDispatcher,
  val repo: SummaryRepository
) : BaseUseCase(scope, dispatcher) {
  private val ingredKey = "ingr"

  //MARK- pull Recipe info
  fun getRecipeInfo(
    src: ArrayList<String>,
    call: (Either<Failure, SummaryRequestModel>) -> Unit = {}
  ) {
     scope.launch {
      val params = HashMap<String, Any>().apply {
        this[ingredKey] = src
      }
      val res = repo.getRecipeInfo(params)
      withContext(dispatcher) {
        call(res)
      }
    }
  }
}