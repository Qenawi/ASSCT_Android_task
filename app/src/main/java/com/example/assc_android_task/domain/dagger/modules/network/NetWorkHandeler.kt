package com.example.assc_android_task.domain.dagger.modules.network

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import dagger.Reusable
import javax.inject.Inject

@Reusable
class NetworkHandler @Inject constructor(private val context: Context) {
  val isConnected get() = context.networkInfo?.isConnected
}

val Context.networkInfo: NetworkInfo?
  @SuppressLint("MissingPermission")
  get() = (this.getSystemService(
    Context.CONNECTIVITY_SERVICE
  ) as ConnectivityManager).activeNetworkInfo
