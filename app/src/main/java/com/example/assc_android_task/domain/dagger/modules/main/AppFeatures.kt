package com.example.assc_android_task.domain.dagger.modules.main

import com.example.assc_android_task.domain.dagger.ViewModelFactoryBindingModule
import com.example.assc_android_task.domain.dagger.modules.gradient_feat.GradientModule
import com.example.assc_android_task.domain.dagger.modules.input_feat.InputModule
import com.example.assc_android_task.domain.dagger.modules.network.NetworkModule
import dagger.Module

@Module(
  includes = [
    ViewModelFactoryBindingModule::class,
    NetworkModule::class,
    InputModule::class,
    GradientModule::class
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