package com.example.assc_android_task.ui.gredient.repo

import com.example.assc_android_task.domain.base.BaseUseCase
import com.example.assc_android_task.domain.network.Either
import com.example.assc_android_task.domain.network.Failure
import com.example.assc_android_task.domain.network.map
import com.example.assc_android_task.domain.network.toResultOrNull
import com.example.assc_android_task.ui.gredient.model.AdapterItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GradientUseCase @Inject constructor(
  val repo: GradientRepo,
  val scope: CoroutineScope,
  val dispatcher: CoroutineDispatcher
) : BaseUseCase(scope, dispatcher) {
  fun pullData(
    src: ArrayList<String>,
    call: (List<Either<Failure, AdapterItem>>) -> Unit = {}
  ) {
    //MARK:- async list
    val asyncList = ArrayList<Deferred<Either<Failure, AdapterItem>>>()
    src.forEach { item -> asyncList.add(buildRequestAsync(item)) }
    scope.launch {
      val result = asyncList.awaitAll()
      withContext(dispatcher) {
        call(result)
      }
    }
  }

  private fun buildRequestAsync(item: String): Deferred<Either<Failure, AdapterItem>> {
    return scope.async { repo.getitemInfo(item) }
  }
}