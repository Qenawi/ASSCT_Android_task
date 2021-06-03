package com.example.assc_android_task.domain.dagger.modules.main

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {
  @Singleton
  @Provides
  fun provideAppContext(): Context = app.applicationContext
}