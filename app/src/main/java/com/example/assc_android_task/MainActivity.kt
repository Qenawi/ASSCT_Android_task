package com.example.assc_android_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assc_android_task.domain.dagger.application.ASSCTApplication

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}