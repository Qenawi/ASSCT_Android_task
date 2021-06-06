package com.example.assc_android_task.domain.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.isActive

//MARK:- BaseUseCase @Docs
abstract class BaseUseCase
(
  private val scope: CoroutineScope,
  private val dispatcher: CoroutineDispatcher
) {

  fun onCleared() {
    if (scope.isActive) {
      scope.cancel()
    }
  }

  //MARK:- Params
  class None
}
