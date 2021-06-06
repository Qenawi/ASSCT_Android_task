package com.example.assc_android_task.domain.dagger

import android.app.Application
import com.example.assc_android_task.MainActivity
import com.example.assc_android_task.domain.dagger.application.ASSCTApplication
import com.example.assc_android_task.domain.dagger.modules.main.AppFeatures
import com.example.assc_android_task.domain.dagger.modules.main.AppModule
import com.example.assc_android_task.ui.ingredient.layout.FragmentIngredient
import com.example.assc_android_task.ui.input.layout.FragmentInput
import com.example.assc_android_task.ui.summary.layout.FragmentSummary
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidInjectionModule::class,
    AppFeatures::class,
    AppModule::class
  ]
)
interface ApplicationComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder
    fun appModule(module: AppModule): Builder
    fun build(): ApplicationComponent
  }

  //MARK:- context
  fun inject(app: ASSCTApplication)
  fun inject(mainActivity: MainActivity)
  //MARK:- fragment
  fun inject(fragmentIngredient: FragmentIngredient)
  fun inject(fragmentInput: FragmentInput)
  fun inject(fragmentSummary: FragmentSummary)
  //MARK:- viewModel
  //MARK:- activity
}
