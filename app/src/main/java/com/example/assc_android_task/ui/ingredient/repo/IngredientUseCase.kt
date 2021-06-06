package com.example.assc_android_task.ui.ingredient.repo

import com.example.assc_android_task.domain.base.BaseUseCase
import com.example.assc_android_task.domain.network.Either
import com.example.assc_android_task.domain.network.Failure
import com.example.assc_android_task.ui.ingredient.model.AdapterItem
import com.example.assc_android_task.ui.ingredient.model.NamingRequestModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//MARK:-  IngredientUseCase @Docs
class IngredientUseCase @Inject constructor(
  val repo: IngredientRepo,
  val scope: CoroutineScope,
  val dispatcher: CoroutineDispatcher
) : BaseUseCase(scope, dispatcher) {
  fun pullData(
    src: ArrayList<String>,
    call: (List<CustomDiffered>) -> Unit = {}
  ) {
    //MARK:- async list
    val asyncList = ArrayList<Deferred<CustomDiffered>>()
    src.forEach { item -> asyncList.add(buildRequestAsync(item)) }
    scope.launch {
      val result = asyncList.awaitAll()
      withContext(dispatcher) {
        call(result)
      }
    }
  }

  //MARK:- populate Async Deferred Object
  private fun buildRequestAsync(item: String): Deferred<CustomDiffered> {
    return scope.async {
      //MARK:- run seq
      val m = repo.getItemInfo(item)
      val n = repo.getItemInfoNaming(item)
      CustomDiffered(m, n)
    }
  }

  //MARK:-test Class
  data class CustomDiffered(
    val name: Either<Failure, AdapterItem>,
    val name2: Either<Failure, NamingRequestModule>
  )
}