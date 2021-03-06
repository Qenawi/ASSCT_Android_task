package com.example.assc_android_task.domain.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assc_android_task.ui.ingredient.viewmodel.IngredientViewModel
import com.example.assc_android_task.ui.input.viewmodel.InputViewModel
import com.example.assc_android_task.ui.summary.viewmodel.SummaryViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Target(
  AnnotationTarget.FUNCTION,
  AnnotationTarget.PROPERTY_GETTER,
  AnnotationTarget.PROPERTY_SETTER
)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Suppress("UNCHECKED_CAST")
@Singleton
class ViewModelFactory
@Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
  ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    val creator =
      creators[modelClass] ?: creators.asIterable()
        .firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
      ?: throw IllegalArgumentException("unknown model class $modelClass")

    return try {
      creator.get() as T
    } catch (e: Exception) {
      throw RuntimeException(e)
    }
  }
}

@Module
abstract class ViewModelFactoryBindingModule {
  @Binds
  internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

  @Binds
  @IntoMap
  @ViewModelKey(InputViewModel::class)
  abstract fun bindInputViewModel(vm: InputViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(IngredientViewModel::class)
  abstract fun bindIngredientViewModel(vm: IngredientViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(SummaryViewModel::class)
  abstract fun bindSummaryViewModel(vm: SummaryViewModel): ViewModel
}
