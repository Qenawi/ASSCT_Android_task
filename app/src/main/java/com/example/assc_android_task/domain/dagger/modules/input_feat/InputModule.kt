package com.example.assc_android_task.domain.dagger.modules.input_feat

import com.example.assc_android_task.domain.dagger.modules.main.AppFeatures.Companion.DispatcherUseCaseName
import com.example.assc_android_task.domain.dagger.modules.main.AppFeatures.Companion.UseCaseScopeName
import com.example.assc_android_task.ui.input.repo.InputUseCase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Named
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

//MARK:-
@Module
class InputModule {

  companion object {
    private const val DaggerKey = "LoginModule"
  }

  @Named(DaggerKey + UseCaseScopeName)
  @Provides
  fun providesCoroutinesScope(): CoroutineScope = object : CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
      get() = job + Dispatchers.IO
  }

  @Named(DaggerKey + DispatcherUseCaseName)
  @Provides
  @Singleton
  fun provideCoroutinesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main


  @Provides
  fun provideInputModule(
    @Named(DaggerKey + UseCaseScopeName)
    scope: CoroutineScope,
    @Named(DaggerKey + DispatcherUseCaseName)
    dispatcher: CoroutineDispatcher
  ): InputUseCase {
    return InputUseCase(scope, dispatcher)
  }
  }
