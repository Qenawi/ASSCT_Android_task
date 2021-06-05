package com.example.assc_android_task.domain.dagger.modules.summary_feat

import com.example.assc_android_task.domain.dagger.modules.main.AppFeatures.Companion.DispatcherUseCaseName
import com.example.assc_android_task.domain.dagger.modules.main.AppFeatures.Companion.UseCaseScopeName
import com.example.assc_android_task.ui.gredient.repo.GradientRepo
import com.example.assc_android_task.ui.gredient.repo.GradientUseCase
import com.example.assc_android_task.ui.input.repo.InputUseCase
import com.example.assc_android_task.ui.summary.repo.SummaryRepository
import com.example.assc_android_task.ui.summary.repo.SummaryUseCase
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
class SummaryModule {

  companion object {
    private const val DaggerKey = "SummaryModule"
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
  fun provideSummaryRepository(repo: SummaryRepository.NetWork): SummaryRepository = repo

  @Provides
  fun provideSummaryUseCase(
    repo: SummaryRepository,
    @Named(DaggerKey + UseCaseScopeName)
    scope: CoroutineScope,
    @Named(DaggerKey + DispatcherUseCaseName)
    dispatcher: CoroutineDispatcher
  ): SummaryUseCase {
    return SummaryUseCase(scope = scope, dispatcher = dispatcher, repo = repo)
  }
}
