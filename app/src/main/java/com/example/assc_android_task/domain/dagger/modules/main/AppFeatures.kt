package com.example.assc_android_task.domain.dagger.modules.main

import com.example.assc_android_task.domain.dagger.ViewModelFactoryBindingModule
import com.example.assc_android_task.domain.dagger.modules.Ingredient_feat.IngredientModule
import com.example.assc_android_task.domain.dagger.modules.input_feat.InputModule
import com.example.assc_android_task.domain.dagger.modules.network.NetworkModule
import com.example.assc_android_task.domain.dagger.modules.summary_feat.SummaryModule
import com.example.assc_android_task.ui.summary.viewmodel.SummaryViewModel
import dagger.Module

@Module(
  includes = [
    ViewModelFactoryBindingModule::class,
    NetworkModule::class,
    InputModule::class,
    IngredientModule::class,
    SummaryModule::class
  ]
)

class AppFeatures {
  companion object {
    //MARK:- useCase Scope
    const val UseCaseScopeName = "useCaseScope"

    //MARK:- dispatcher Scope
    const val DispatcherUseCaseName = "dispatcherName"
  }
}