package com.example.assc_android_task.domain.network

import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitService @Inject constructor(retrofit: Retrofit) : RetrofitApi {
  private val api by lazy { retrofit.create(RetrofitApi::class.java) }
  override fun single_food_item(
    app_id: String,
    app_key: String,
    ingred: String
  ) = api.single_food_item(app_id, app_key, ingred)
}


