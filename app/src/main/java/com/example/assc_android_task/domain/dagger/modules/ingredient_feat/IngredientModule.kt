package com.example.assc_android_task.domain.dagger.modules.Ingredient_feat

import com.example.assc_android_task.domain.dagger.modules.main.AppFeatures.Companion.DispatcherUseCaseName
import com.example.assc_android_task.domain.dagger.modules.main.AppFeatures.Companion.UseCaseScopeName
import com.example.assc_android_task.ui.ingredient.repo.IngredientRepo
import com.example.assc_android_task.ui.ingredient.repo.IngredientUseCase
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
class IngredientModule {

  companion object {
    private const val DaggerKey = "IngredientModule"
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
  fun provideIngredientRepo(repo: IngredientRepo.NetWork): IngredientRepo = repo

  @Provides
  fun provideIngredientUseCase(
    repo: IngredientRepo,
    @Named(DaggerKey + UseCaseScopeName)
    scope: CoroutineScope,
    @Named(DaggerKey + DispatcherUseCaseName)
    dispatcher: CoroutineDispatcher
  ): IngredientUseCase {
    return IngredientUseCase(repo, scope, dispatcher)
  }
}
