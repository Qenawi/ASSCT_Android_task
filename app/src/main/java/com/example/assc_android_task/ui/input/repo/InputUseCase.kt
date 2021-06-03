package com.example.assc_android_task.ui.input.repo

import com.example.assc_android_task.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class InputUseCase @Inject constructor(
  scope: CoroutineScope,
  dispatcher: CoroutineDispatcher
) : BaseUseCase(scope, dispatcher) {

  //MARK:- check if string was valid
  fun isInputValid(str: String?): Boolean {
    return !str.isNullOrEmpty()
  }

  //MARK:- convert string to array list
  fun mapStringToArrayList(str: String): ArrayList<String> {
    return if (str.contains("\n")) {
      str.split("\n").toCollection(ArrayList())
    } else arrayListOf()
  }
}