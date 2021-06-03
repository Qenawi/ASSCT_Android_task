package com.example.assc_android_task.domain.dagger.modules.gradient_feat

import com.example.assc_android_task.domain.dagger.modules.main.AppFeatures.Companion.DispatcherUseCaseName
import com.example.assc_android_task.domain.dagger.modules.main.AppFeatures.Companion.UseCaseScopeName
import com.example.assc_android_task.ui.gredient.repo.GradientRepo
import com.example.assc_android_task.ui.gredient.repo.GradientUseCase
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
class GradientModule {

  companion object {
    private const val DaggerKey = "GradientModule"
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
  fun provideGradientRepo(repo: GradientRepo.NetWork): GradientRepo = repo

  @Provides
  fun provideGradientUseCase(
    repo: GradientRepo,
    @Named(DaggerKey + UseCaseScopeName)
    scope: CoroutineScope,
    @Named(DaggerKey + DispatcherUseCaseName)
    dispatcher: CoroutineDispatcher
  ): GradientUseCase {
    return GradientUseCase(repo, scope, dispatcher)
  }
}
