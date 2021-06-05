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

  override fun getRecipeDetails(
    app_id: String,
    app_key: String,
    recipe: HashMap<String, Any>
  ) = api.getRecipeDetails(app_id, app_key, recipe)
}


