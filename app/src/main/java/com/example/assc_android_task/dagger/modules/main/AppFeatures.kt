package com.example.assc_android_task.dagger.modules.main

import com.example.assc_android_task.dagger.ViewModelFactoryBindingModule
import dagger.Module

@Module(
  includes = [ViewModelFactoryBindingModule::class]
)

class AppFeatures {
  companion object {
    //MARK:- useCase Scope
    const val UseCaseScopeName = "useCaseScope"

    //MARK:- dispatcher Scope
    const val DispatcherUseCaseName = "dispatcherName"
  }
}