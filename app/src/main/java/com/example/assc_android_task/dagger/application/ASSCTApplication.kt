package com.example.assc_android_task.dagger.application

import android.app.Application
import com.example.assc_android_task.dagger.ApplicationComponent
import com.example.assc_android_task.dagger.DaggerApplicationComponent
import com.example.assc_android_task.dagger.modules.main.AppModule

class ASSCTApplication: Application()
{
  override fun onCreate() {
    super.onCreate()
    initDagger()
  }
  private fun initDagger(){
    appComponent =
      DaggerApplicationComponent.builder().application(this).appModule(AppModule(this)).build()
    appComponent.inject(this)
  }

  //MARK:- component
  companion object {
    lateinit var appComponent: ApplicationComponent private set
  }
}