package com.example.assc_android_task.domain.dagger.modules.network

import com.example.assc_android_task.domain.dagger.modules.network.NetworkModule.Companion.NetworkRequestTag
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@Module
class NetworkModule {

  companion object {

    private val BASE_URL = "https://api.edamam.com/api/"
    const val NetworkRequestTag = "NetworkRequestTag"
  }

  @Reusable
  @Provides
  fun provideGson(): Gson = GsonBuilder().setLenient().create()

  @Reusable
  @Provides
  fun provideOkHttpInterceptor(): Interceptor = LoggingInterceptor()

  @Reusable
  @Provides
  fun provideOkhttpClient(
    loggingInterceptor: LoggingInterceptor
  ): OkHttpClient {
    val http = OkHttpClient.Builder()
    http.callTimeout(65, TimeUnit.SECONDS)
    http.writeTimeout(65, TimeUnit.SECONDS)
    http.readTimeout(65, TimeUnit.SECONDS)
    return http.addInterceptor(loggingInterceptor).build()
  }

  @Reusable
  @Provides
  fun provideRetrofit(
    gson: Gson,
    okHttpClient: OkHttpClient
  ): Retrofit {
    return Retrofit.Builder()
      .addConverterFactory(GsonConverterFactory.create(gson))
      .baseUrl(BASE_URL)
      .client(okHttpClient)
      .build()
  }
}

//MARK:- custom logging interceptor
class LoggingInterceptor @Inject constructor() : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request = chain.request()
    Timber.tag(NetworkRequestTag)
      .v("Sending request ${request.url}  \n  ${request.headers}  ${request.body} ")
    val response = chain.proceed(request)
    Timber.tag(NetworkRequestTag)
      .v(
        "Received response for ${response.request.url} \n ${response.receivedResponseAtMillis} \n ${response.headers}  \n  ${request.body} "
      )
    return response
  }
}


