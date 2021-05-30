package com.example.assc_android_task.dagger.modules.main

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

  /*
  @Reusable
  @Provides
  fun provideSharedPrefs(app: Application): SharedPreferences
  {
    app.getPrefs()
    return app.getSharedPreferences(app.getString(R.string.app_prefs), 0)
  }

   */
}