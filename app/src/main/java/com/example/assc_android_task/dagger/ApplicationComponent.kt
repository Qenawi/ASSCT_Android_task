package com.example.assc_android_task.dagger

import android.app.Application
import com.example.assc_android_task.dagger.application.ASSCTApplication
import com.example.assc_android_task.dagger.modules.main.AppFeatures
import com.example.assc_android_task.dagger.modules.main.AppModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AppFeatures::class,
    AppModule::class
  ]
)
interface ApplicationComponent{

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder
    fun appModule(module: AppModule): Builder
    fun build(): ApplicationComponent
  }
  //MARK:- context
  fun inject(app: ASSCTApplication)
  //MARK:- fragment

  //MARK:- viewModel

  //MARK:- activity
}
