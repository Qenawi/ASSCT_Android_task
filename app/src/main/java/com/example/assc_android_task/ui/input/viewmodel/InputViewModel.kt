package com.example.assc_android_task.ui.input.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import com.example.assc_android_task.domain.base.BaseViewModel
import com.example.assc_android_task.ui.input.protocol.InputViewProtocol
import com.example.assc_android_task.ui.input.repo.InputUseCase
import javax.inject.Inject
//MARK:- InputViewModel @Docs

class InputViewModel @Inject constructor(
  app: Application,
  private val useCase: InputUseCase
) : BaseViewModel<InputUseCase>(app, useCase) {
  //MARK:- uiModel
  val inputString = ObservableField<String>("")

  //MARK:- view
  var view: InputViewProtocol? = null

  //MARK:- on analyze Button Click
  fun onAnalyzed() {
    if (useCase.isInputValid(inputString.get())) splitAndSend()
  }

  //MARK:- Split Input Data
   private fun splitAndSend() {
    val splitedArray = useCase.mapStringToArrayList(inputString.get() ?: "")
    view?.openIngredient(splitedArray)
  }
}